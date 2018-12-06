package com.project.usermanagement.service;

import com.project.usermanagement.model.Role;
import com.project.usermanagement.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role addRole(Role role){
        return roleRepository.save(role);
    }
}
