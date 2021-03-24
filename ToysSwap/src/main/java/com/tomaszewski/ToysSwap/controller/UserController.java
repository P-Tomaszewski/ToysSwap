package com.tomaszewski.ToysSwap.controller;

import com.tomaszewski.ToysSwap.model.User;
import com.tomaszewski.ToysSwap.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @PostMapping("/races")
    ResponseEntity<User> createUser(@RequestBody @Valid User toCreate){
        User result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping("/races")
    ResponseEntity<List<User>> readAllUsers(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }
}
