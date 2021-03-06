package com.tomaszewski.ToysSwap.controller;

import com.tomaszewski.ToysSwap.enums.AgeCategory;
import com.tomaszewski.ToysSwap.enums.Brand;
import com.tomaszewski.ToysSwap.enums.ProductCategory;
import com.tomaszewski.ToysSwap.model.Advertisement;
import com.tomaszewski.ToysSwap.model.projection.AdvertisementWriteModel;
import com.tomaszewski.ToysSwap.repository.AdvertisementRepository;
import com.tomaszewski.ToysSwap.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdvertisementController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final AdvertisementRepository repository;
    private final UserRepository userRepository;

    public AdvertisementController(AdvertisementRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
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

    @ResponseBody
    @GetMapping(value = "/advertisements/age/{ageCategory}")
    ResponseEntity<List<Advertisement>> getAdvertisementByAgeCategory(@PathVariable("ageCategory") String ageCategory) {
        logger.warn("ret age");
        return ResponseEntity.ok(repository.findByAgeCategory(ageCategory));
    }

    @ResponseBody
    @GetMapping(value = "/advertisements/age/category/{category}")
    ResponseEntity<List<Advertisement>> getAdvertisementByCategory(@PathVariable("category")String category) {
        String[] parts = category.split("\\$");
        System.out.println(parts[0] + " " + parts[1] + " "+ parts[2] + " " + parts[3]);
        logger.warn(category);

        if(!parts[1].equals("undefined") && !parts[2].equals("undefined") && !parts[3].equals("undefined")){
            return ResponseEntity.ok(repository.findByCategoryCityBrand(parts[0], parts[1], parts[2], parts[3]));
        }
        if(!parts[1].equals("undefined") && parts[2].equals("undefined") && parts[3].equals("undefined")){
            return ResponseEntity.ok(repository.findByBrand(parts[0], parts[1]));
        }
        if(parts[1].equals("undefined") && !parts[2].equals("undefined") && parts[3].equals("undefined")){
            return ResponseEntity.ok(repository.findByCity(parts[0], parts[2]));
        }
        if(parts[1].equals("undefined") && parts[2].equals("undefined") && !parts[3].equals("undefined")){
            return ResponseEntity.ok(repository.findByCategory(parts[0], parts[3]));
        }
        if(!parts[1].equals("undefined") && !parts[2].equals("undefined") && parts[3].equals("undefined")){
            return ResponseEntity.ok(repository.findByBrandCity(parts[0], parts[1], parts[2]));
        }
        if(parts[1].equals("undefined") && !parts[2].equals("undefined") && !parts[3].equals("undefined")){
            return ResponseEntity.ok(repository.findByCategoryCity(parts[0], parts[2], parts[3]));
        }
        if(!parts[1].equals("undefined") && parts[2].equals("undefined") && !parts[3].equals("undefined")){
            return ResponseEntity.ok(repository.findByCategoryBrand(parts[0],parts[1], parts[3]));
        }
        if(parts[1].equals("empty") && parts[2].equals("empty") && parts[3].equals("empty")){
            return ResponseEntity.ok(repository.findByAgeCategory(parts[0]));
        } else {
            System.out.println(parts[0] + " " + parts[3]);
            return ResponseEntity.ok(repository.findByAgeCategory(parts[0]));
        }

//        return ResponseEntity.ok(repository.findByCategory(category).stream()
//                .filter(g -> g.getBrand().equals(parts[1]))
//                .filter(g -> g.getCity().equals(parts[2]))
//                .filter(g -> g.getCategory().equals(parts[3]))
//                .collect(Collectors.toList()));

    }




    @DeleteMapping("/advertisements/{id}")
    public void deleteAdvertisement(@PathVariable("id") int id) {
            logger.warn("del adv");
        repository.deleteById(id);
    }

    @PutMapping("/advertisements/{id}")
    ResponseEntity<Advertisement> updateAdvertisement(@PathVariable("id") int id, @RequestBody @Valid AdvertisementWriteModel advertisementWriteModel) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Advertisement toUpdate = new Advertisement();
        int userId = userRepository.findByUsername(advertisementWriteModel.getLogin()).get().getId();
        toUpdate.setUser(userRepository.findById(userId).get());
        toUpdate.setPrice(advertisementWriteModel.getPrice());
        toUpdate.setDescription(advertisementWriteModel.getDescription());
        toUpdate.setTitle(advertisementWriteModel.getTitle());
        toUpdate.setCategory(advertisementWriteModel.getCategory());
        toUpdate.setBrand(advertisementWriteModel.getBrand());
        toUpdate.setPhoto(advertisementWriteModel.getPhoto());
        toUpdate.setAgeCategory(advertisementWriteModel.getAgeCategory());
        toUpdate.setCity(advertisementWriteModel.getCity());
        toUpdate.setId(id);
        Advertisement result = repository.save(toUpdate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

//    @ResponseBody
//    @PostMapping(value = "/upload")
//    public void postImage(@RequestParam("file") File file) throws IOException {
//        System.out.println("received");
//    }

    @ResponseBody
    @PostMapping("/advertisements")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    ResponseEntity<Advertisement> createAdvertisement(@RequestBody AdvertisementWriteModel advertisementWriteModel) {
        Advertisement toCreate = new Advertisement();
        int id = userRepository.findByUsername(advertisementWriteModel.getLogin()).get().getId();
        toCreate.setUser(userRepository.findById(id).get());
        toCreate.setPrice(advertisementWriteModel.getPrice());
        toCreate.setDescription(advertisementWriteModel.getDescription());
        toCreate.setTitle(advertisementWriteModel.getTitle());
        toCreate.setCategory(advertisementWriteModel.getCategory());
        toCreate.setBrand(advertisementWriteModel.getBrand());
        toCreate.setPhoto(advertisementWriteModel.getPhoto());
        toCreate.setAgeCategory(advertisementWriteModel.getAgeCategory());
        toCreate.setCity(advertisementWriteModel.getCity());
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
