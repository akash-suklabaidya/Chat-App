package com.ChatApp.Chat.App.repository;

import com.ChatApp.Chat.App.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByReceiverId(String receiverId);
}
