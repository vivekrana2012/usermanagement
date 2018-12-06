package com.project.usermanagement.service;

import com.project.usermanagement.model.Role;
import com.project.usermanagement.model.User;
import com.project.usermanagement.repository.RoleRepository;
import com.project.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }

    public User addUser(User user){

        return userRepository.save(user);
    }

}
