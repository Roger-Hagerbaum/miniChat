package com.minichat;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByUsername(String userName);
    @Query("SELECT u.port FROM User u WHERE u.username= ?1")
    int getUserPort(String userName);

    boolean existsByUsername(String username);
    @Query("SELECT COUNT (*) FROM User u")
    int countByUsername(String userName);
}

