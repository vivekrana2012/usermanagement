package com.project.usermanagement.controller;

import com.project.usermanagement.model.Role;
import com.project.usermanagement.service.RoleService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/add")
    public boolean addRole(@Valid @RequestBody Role role, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return false;
        }

        roleService.addRole(role);

        System.out.println("Role Added!");

        return true;
    }

}
