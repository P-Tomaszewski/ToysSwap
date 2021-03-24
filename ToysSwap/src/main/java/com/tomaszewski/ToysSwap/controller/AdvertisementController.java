package com.tomaszewski.ToysSwap.controller;

import com.tomaszewski.ToysSwap.model.Advertisement;
import com.tomaszewski.ToysSwap.repository.AdvertisementRepository;
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

public class AdvertisementController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    private final AdvertisementRepository repository;

    public AdvertisementController(AdvertisementRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @PostMapping("/races")
    ResponseEntity<Advertisement> createAdvertisement(@RequestBody @Valid Advertisement toCreate){
        Advertisement result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping("/races")
    ResponseEntity<List<Advertisement>> readAllAdvertisements(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }
}
