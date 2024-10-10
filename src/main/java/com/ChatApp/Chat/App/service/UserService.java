package com.ChatApp.Chat.App.service;


import com.ChatApp.Chat.App.models.Status;
import com.ChatApp.Chat.App.models.User;
import com.ChatApp.Chat.App.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        user.setStatus(Status.ONLINE);
        return userRepository.save(user);
    }

    public void disconnect(User user){
        var storedUser=userRepository.findById(user.getUserId())
                .orElse(null);

        if(storedUser!=null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers(){
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
