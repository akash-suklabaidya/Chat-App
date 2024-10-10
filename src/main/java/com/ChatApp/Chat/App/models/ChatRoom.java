package com.ChatApp.Chat.App.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class ChatRoom {

    @Id
    private String chatRoomId;
    private String chatId;
    private String senderId;
    private String receiverId;

}
