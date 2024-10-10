package com.ChatApp.Chat.App.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    @Id
    private String chatMessageId;
    private String chatId;
    private String senderId;
    private String receiverId;
    private String content;
    private Date timestamp;

}
