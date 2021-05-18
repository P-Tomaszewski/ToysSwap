package com.tomaszewski.ToysSwap.repository;

import com.tomaszewski.ToysSwap.model.Advertisement;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
@Primary
public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer>{
    List<Advertisement> findAll();
    Optional<Advertisement> findById(Integer id);
    Advertisement save(Advertisement entity);
    boolean existsById(Integer id);
    void deleteById(int id);
    List<Advertisement> findByAgeCategory(String ageCategory);
}
