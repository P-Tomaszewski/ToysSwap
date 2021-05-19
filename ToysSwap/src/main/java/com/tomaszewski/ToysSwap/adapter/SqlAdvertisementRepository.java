package com.tomaszewski.ToysSwap.adapter;

import com.tomaszewski.ToysSwap.model.Advertisement;
import com.tomaszewski.ToysSwap.repository.AdvertisementRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SqlAdvertisementRepository extends AdvertisementRepository, JpaRepository<Advertisement, Integer> {
    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1")
    List<Advertisement> findByAgeCategory(String ageCategory);

    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1 AND CATEGORY = ?2")
    List<Advertisement> findByCategory(String ageCategory, String category);

    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1 AND BRAND = ?2 AND CITY = ?3 AND CATEGORY =?4")
    List<Advertisement> findByCategoryCityBrand(String ageCategory, String brand, String city ,String category);

    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1 AND BRAND = ?2")
    List<Advertisement> findByBrand(String ageCategory, String brand);

    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1 AND CITY = ?2")
    List<Advertisement> findByCity(String ageCategory, String city);

    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1 AND BRAND = ?2 AND CITY =?3")
    List<Advertisement> findByBrandCity(String ageCategory,String brand, String city);

    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1 AND CITY = ?2 AND = ?3")
    List<Advertisement> findByCategoryCity(String ageCategory, String city, String category);

    @Override
    @Query(nativeQuery = true, value = "select * from Advertisement where AGE_CATEGORY = ?1 AND BRAND = ?2 AND CATEGORY =?3")
    List<Advertisement> findByCategoryBrand(String ageCategory, String brand, String category);
}
