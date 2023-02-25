package com.tmg.xpenses.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

   /* @Autowired
    UserGroupRepository userGroupRepository;*/

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(u->users.add(u));
        return users;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id.intValue());
    }
}
