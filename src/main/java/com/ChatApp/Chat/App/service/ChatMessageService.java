package com.ChatApp.Chat.App.service;


import com.ChatApp.Chat.App.models.ChatMessage;
import com.ChatApp.Chat.App.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        if (chatMessage.getGroupId() == null) {
            String chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(), chatMessage.getReceiverId(), true)
                    .orElseThrow();
            chatMessage.setChatId(chatId);
        }
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(
            String senderId,String receiverId
    ){
        String chatId=chatRoomService.getChatRoomId(
                senderId,
                receiverId,false
        ).orElse(null);
//          return chatId.map(chatMessageRepository::findByChatId)
//                  .orElse(new ArrayList<>());
        return chatMessageRepository.findByChatId(chatId);
    }

    public List<ChatMessage> findGroupMessages(String groupId) {
        return chatMessageRepository.findByGroupId(groupId);
    }

}
