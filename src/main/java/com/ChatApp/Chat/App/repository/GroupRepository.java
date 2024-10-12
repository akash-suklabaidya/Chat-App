package com.ChatApp.Chat.App.repository;

import com.ChatApp.Chat.App.models.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GroupRepository extends MongoRepository<Group, String> {
    Optional<Group> findByGroupName(String groupName);
}
