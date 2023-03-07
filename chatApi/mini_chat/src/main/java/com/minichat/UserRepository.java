package com.minichat;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.port FROM User u WHERE u.userName = ?1")
    int getUserPort(String userName);

    @Query("SELECT u.password FROM User u WHERE u.userName = ?1")
    String getUserName(String userName);

    @Query("SELECT u.loggin FROM User u WHERE u.userName = ?1")
    boolean getLogginStatus(String userName);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.loggin = true WHERE u.userName = ?1")
    void setLogginStatus(String userName);

    }
