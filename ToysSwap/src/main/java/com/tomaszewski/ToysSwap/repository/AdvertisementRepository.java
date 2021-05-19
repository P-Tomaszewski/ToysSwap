package com.tomaszewski.ToysSwap.repository;

import com.tomaszewski.ToysSwap.model.Advertisement;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Primary
@Repository
public interface AdvertisementRepository {
    List<Advertisement> findAll();
    Optional<Advertisement> findById(Integer id);
    Advertisement save(Advertisement entity);
    boolean existsById(Integer id);
    void deleteById(int id);
    List<Advertisement> findByAgeCategory(String ageCategory);
    List<Advertisement> findByCategory(String ageCategory, String category);
    List<Advertisement> findByBrand(String ageCategory, String brand);
    List<Advertisement> findByCity(String ageCategory, String city);
    List<Advertisement> findByCategoryCity(String ageCategory, String category, String city);
    List<Advertisement> findByCategoryBrand(String ageCategory, String category, String brand);
    List<Advertisement> findByBrandCity(String ageCategory, String brand, String city);
    List<Advertisement> findByCategoryCityBrand(String ageCategory, String category, String city, String brand);


}
