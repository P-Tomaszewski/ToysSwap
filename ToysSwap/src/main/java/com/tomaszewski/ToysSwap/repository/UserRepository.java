package com.tomaszewski.ToysSwap.repository;

import com.tomaszewski.ToysSwap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//public interface UserRepository extends CrudRepository<User, Integer> {
public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findAll();
//    Optional<User> findById(Integer id);
//    User save(User entity);
//    boolean existsById(Integer id);
//    void deleteById(int id);
Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
