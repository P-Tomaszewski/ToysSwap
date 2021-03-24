package com.tomaszewski.ToysSwap.repository;

import com.tomaszewski.ToysSwap.model.Advertisement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    List<Advertisement> findAll();
    Optional<Advertisement> findById(Integer id);
    Advertisement save(Advertisement entity);
    boolean existsById(Integer id);
    void deleteById(int id);
}
