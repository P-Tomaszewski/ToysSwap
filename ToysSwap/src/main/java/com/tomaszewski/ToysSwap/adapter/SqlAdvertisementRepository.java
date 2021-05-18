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
}
