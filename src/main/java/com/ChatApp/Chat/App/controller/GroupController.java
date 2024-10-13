package com.ChatApp.Chat.App.controller;

import com.ChatApp.Chat.App.models.Group;
import com.ChatApp.Chat.App.models.User;
import com.ChatApp.Chat.App.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/group")

public class GroupController {

    @Autowired
    private GroupService groupService;

//    @PostMapping("/create")
//    public ResponseEntity<Group> createGroup(@RequestBody Group group,
//                                             ) {
//            group.setCreatedBy(currentUser.getId());
//    }

    @PostMapping
    public  ResponseEntity<Group> crateGroup(@RequestBody Group group){
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @DeleteMapping("/{groupId}/deleteGroup")
    public ResponseEntity<?> deleteGroup(@PathVariable String groupId){
        return ResponseEntity.ok(groupService.deleteGroup(groupId));
    }

    @PostMapping("/{groupId}/{userId}")
    public ResponseEntity<Group> addMember(@PathVariable String groupId, @PathVariable String userId){
        return ResponseEntity.ok(groupService.addMember(groupId, userId));
    }

    @DeleteMapping("{groupId}/{userId}")
    public ResponseEntity<Group> removeMember(@PathVariable String groupId, @PathVariable String userId){
        return ResponseEntity.ok(groupService.removeMember(groupId, userId));
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> getGroupById(@PathVariable String groupId){
        return ResponseEntity.ok(groupService.getGroupById(groupId));
    }

    @GetMapping
    public ResponseEntity<?> getAllGroup(){
        return ResponseEntity.ok(groupService.getAllGroups());
    }

}
