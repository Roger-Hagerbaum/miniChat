package com.minichat;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByuserName(String userName);
}
