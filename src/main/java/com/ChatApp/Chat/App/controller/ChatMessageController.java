package com.ChatApp.Chat.App.controller;


import com.ChatApp.Chat.App.models.ChatMessage;
import com.ChatApp.Chat.App.models.ChatNotification;
import com.ChatApp.Chat.App.repository.ChatMessageRepository;
import com.ChatApp.Chat.App.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(
            @Payload ChatMessage chatMessage
    ){
        ChatMessage savedMsg=chatMessageService.save(chatMessage);

        // john/queue/messages
        messagingTemplate.convertAndSendToUser(
            chatMessage.getReceiverId(),"/queue/messages",
                ChatNotification.builder()
                        .id(savedMsg.getChatMessageId())
                        .senderId(savedMsg.getSenderId())
                        .receiverId(savedMsg.getReceiverId())
                        .content(savedMsg.getContent())
                        .build()
        );

    }


    @GetMapping("/messages/{senderId}/{receiverId}")
    public ResponseEntity<List<ChatMessage>>  findChatMessages(
            @PathVariable("senderId") String senderId,
            @PathVariable("receiverId") String receiverId
    ){

        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, receiverId));
    }

}
