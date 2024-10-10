package com.ChatApp.Chat.App.repository;

import com.ChatApp.Chat.App.models.Status;
import com.ChatApp.Chat.App.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByStatus(Status status);

}
