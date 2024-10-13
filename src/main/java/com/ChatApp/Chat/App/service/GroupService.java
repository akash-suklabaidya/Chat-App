package com.ChatApp.Chat.App.service;

import com.ChatApp.Chat.App.models.Group;
import com.ChatApp.Chat.App.models.User;
import com.ChatApp.Chat.App.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private  GroupRepository groupRepository;

    @Autowired
    private  UserService userService;

    public Group createGroup(Group group) {
        group.setCreatedAt(new Date());
        group.setUpdatedAt(new Date());
        return groupRepository.save(group);
    }
    public Group updateGroup(String groupId, Group updatedGroup) {
        Group existingGroup = groupRepository.findById(groupId)
                .orElseThrow(()-> new NoSuchElementException("Group" +
                        "not found"));
        existingGroup.setGroupName(updatedGroup.getGroupName());
        existingGroup.setMembers(updatedGroup.getMembers());
        existingGroup.setUpdatedAt(new Date());

        return groupRepository.save(existingGroup);
    }

    public boolean deleteGroup(String groupId) {
        if(!groupRepository.existsById(groupId)){
            throw new NoSuchElementException("Group not found");
        }
        groupRepository.deleteById(groupId);
        return true;
    }

    public Group addMember(String groupId, String userId) {
        Group group=groupRepository.findById(groupId)
                .orElseThrow();
        User user=userService.findByUserId(userId);
        group.getMembers().add(user);
        return groupRepository.save(group);
    }

    public Group removeMember(String groupId, String userId) {
        Group group=groupRepository.findById(groupId).orElseThrow();
        User user=userService.findByUserId(userId);
        group.getMembers().remove(user);
        return groupRepository.save(group);
    }

    public Optional<Group> getGroupById(String groupId) {
        return groupRepository.findById(groupId);
    }
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public List<Group> getGroupByUserId(String userId) {
        return groupRepository.findAll()
                .stream().filter(
                        group->group.getMembers().contains(userId)
                ).toList();
    }

}
