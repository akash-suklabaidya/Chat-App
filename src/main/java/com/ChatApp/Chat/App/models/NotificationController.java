package com.ChatApp.Chat.App.models;

import com.ChatApp.Chat.App.models.Notification;
import com.ChatApp.Chat.App.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable String userId) {
        return ResponseEntity.ok(notificationService.getNotificationsForUser(userId));
    }

    @PutMapping("/{notificationId}/seen")
    public ResponseEntity<Void> markNotificationAsSeen(@PathVariable String notificationId) {
        notificationService.markAsSeen(notificationId);
        return ResponseEntity.ok().build();
    }
}
