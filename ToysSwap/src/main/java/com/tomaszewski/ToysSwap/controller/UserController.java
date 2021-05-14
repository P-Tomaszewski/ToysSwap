package com.tomaszewski.ToysSwap.controller;

import com.tomaszewski.ToysSwap.model.User;
import com.tomaszewski.ToysSwap.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody @Valid User toCreate){
        User result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping("/users")
    ResponseEntity<List<User>> readAllUsers(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @ResponseBody
    @GetMapping(value = "/user/{username}")
    public User getUserById(@PathVariable("username") String username){
        logger.warn("Exposing all tasks");
        User user =  repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return user;
    }


}
