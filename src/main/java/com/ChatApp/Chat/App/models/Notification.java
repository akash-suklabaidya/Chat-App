package com.ChatApp.Chat.App.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Notification {
    @Id
    private String id;
    private String receiverId;
    private String content;
    private boolean seen;
}
