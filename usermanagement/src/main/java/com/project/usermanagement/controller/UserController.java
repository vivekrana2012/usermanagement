package com.project.usermanagement.controller;

import com.project.usermanagement.model.User;
import com.project.usermanagement.responseentity.UserResponseEntity;
import com.project.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(new UserResponseEntity("Error", HttpStatus.BAD_REQUEST));
        }

        userService.addUser(user);

        return ResponseEntity.ok(new UserResponseEntity("Success", HttpStatus.OK));
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id){
        System.out.println("trying to find the user.");

        Optional<User> user = userService.findById(id);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.badRequest().body(new UserResponseEntity("User does not exists.", HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/get/email/{emailId}")
    public ResponseEntity getUserById(@PathVariable("emailId") String emailId){
        System.out.println("trying to find the user.");

        Optional<User> user = userService.findByEmailId(emailId);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.badRequest().body(new UserResponseEntity("User does not exists.", HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<UserResponseEntity> handleException(Exception ex){
        logger.info("Exception raised!!\n");
        return ResponseEntity.badRequest().body(new UserResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
