package com.ChatApp.Chat.App.service;


import com.ChatApp.Chat.App.models.ChatRoom;
import com.ChatApp.Chat.App.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(
            String senderId,
            String receiverId,
            boolean createNewRoomIfNotExist
    ){

        return chatRoomRepository.findBySenderIdAndReceiverId(senderId,receiverId)
                .map(ChatRoom::getChatId).or(()->{
                    if(createNewRoomIfNotExist){
                        var chatId=createChatId(senderId,receiverId);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });
    }

    private String createChatId(String senderId, String receiverId) {
        var chatId=String.format("%s%s",senderId,receiverId);//akash_bikash
        ChatRoom senderReceiver=ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .receiverId(receiverId)
                .build();
        ChatRoom receiverSender=ChatRoom.builder()
                .chatId(chatId)
                .senderId(receiverId)
                .receiverId(senderId)
                .build();

        chatRoomRepository.save(senderReceiver);
        chatRoomRepository.save(receiverSender);
        return chatId;
    }

}
