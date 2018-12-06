package com.project.usermanagement.service;

import com.project.usermanagement.model.Role;
import com.project.usermanagement.repository.RoleRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public Optional<Role> findRoleById(long id){

        return roleRepository.findById(id);
    }

    public List<Role> getAllRoles() {

        List<Role> roles = new ArrayList<>();

        roleRepository.findAll().forEach(roles::add);

        return roles;
    }
}
