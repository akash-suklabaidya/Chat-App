package com.ChatApp.Chat.App.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Group {

    @Id
    private String groupId;
    private String groupName;
//    private String createdBy;
    private List<String> members = new ArrayList<>();
    private Date createdAt;
    private Date updatedAt;

}
