package com.tomaszewski.ToysSwap.controller;

import com.tomaszewski.ToysSwap.enums.AgeCategory;
import com.tomaszewski.ToysSwap.enums.Brand;
import com.tomaszewski.ToysSwap.enums.ProductCategory;
import com.tomaszewski.ToysSwap.model.Advertisement;
import com.tomaszewski.ToysSwap.model.projection.AdvertisementWriteModel;
import com.tomaszewski.ToysSwap.repository.AdvertisementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdvertisementController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final AdvertisementRepository repository;

    public AdvertisementController(AdvertisementRepository repository) {
        this.repository = repository;
    }


    @ResponseBody
    @GetMapping("/advertisements")
    ResponseEntity<List<Advertisement>> readAllAdvertisements() {
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @ResponseBody
    @GetMapping(value = "/advertisements/{id}")
    public Advertisement getAdvertisement(@PathVariable("id") int id) {
        logger.warn("ret adv");
        return repository.findById(id).get();
    }

//    @ResponseBody
//    @PostMapping(value = "/upload")
//    public void postImage(@RequestParam("file") File file) throws IOException {
//        System.out.println("received");
//    }

    @ResponseBody
    @PostMapping("/advertisements")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement toCreate) {
        Advertisement result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @PostMapping(value = "/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
//                System.out.println(file.getResource().getFilename());
                UUID uuid = UUID.randomUUID();
                String filename = uuid.toString();
                byte[] bytes = file.getBytes();
                File fsFile = new File(filename);
                fsFile.createNewFile();
                String filePath = "C:/Users/P_Tomaszewski/toys-swap/src/assets/" + filename;
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(filePath));
                stream.write(bytes);
                stream.close();


                logger.info("File {} has been successfully uploaded as {}", new Object[]{file.getOriginalFilename(), filename});
                Advertisement advertisement = repository.findById(
                        Integer.parseInt(file.getResource().getFilename())).get();
                advertisement.setPhoto(filename);
                System.out.println((file
                        .getResource()
                        .getFilename()));
                repository.save(advertisement);

            } catch (Exception e) {
                logger.error("File has not been uploaded", e);
            }
        } else {
            logger.error("Uploaded file is empty");
        }
        return "redirect:/";
    }
}
