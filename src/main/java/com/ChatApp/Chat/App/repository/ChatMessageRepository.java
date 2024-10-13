package com.ChatApp.Chat.App.repository;

import com.ChatApp.Chat.App.models.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    List<ChatMessage> findByChatId(String chatId);
    List<ChatMessage> findByGroupId(String groupId);

}
