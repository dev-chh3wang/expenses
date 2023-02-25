package com.tmg.xpenses.groups;

import com.tmg.xpenses.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repository;
    @Autowired
    private UserRepository userRepository;


    public Group save(Group group) {
        return repository.save(group);
    }

    public Optional<Group> findById(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer groupId) {
        repository.deleteById(groupId);
    }
}
