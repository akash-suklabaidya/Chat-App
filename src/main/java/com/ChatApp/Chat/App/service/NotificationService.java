package com.ChatApp.Chat.App.service;

import com.ChatApp.Chat.App.models.Notification;
import com.ChatApp.Chat.App.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(String userId) {
        return notificationRepository.findByReceiverId(userId);
    }

    public void markAsSeen(String notificationId) {
        Notification notification = notificationRepository.findById(notificationId).orElseThrow();
        notification.setSeen(true);
        notificationRepository.save(notification);
    }
}
