package com.project.usermanagement.controller;

import com.project.usermanagement.model.Role;
import com.project.usermanagement.service.RoleService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/get/{id}")
    public ResponseEntity getRoleById(@PathVariable("id") long id){

        Optional<Role> role = roleService.findRoleById(id);

        if(role.isPresent()){
            return ResponseEntity.ok(role.get());
        }

        return ResponseEntity.badRequest().body(new Role());
    }

    @GetMapping("/get/all")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

}
