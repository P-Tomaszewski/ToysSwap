package com.tomaszewski.ToysSwap.repository;

import com.tomaszewski.ToysSwap.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findById(Integer id);
    User save(User entity);
    boolean existsById(Integer id);
    void deleteById(int id);
}
