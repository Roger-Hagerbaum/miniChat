package com.minichat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u.port FROM User u WHERE u.userName = ?1")
    int getUserPort(String userName);
}
