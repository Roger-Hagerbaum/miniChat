package com.minichat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private  String password;
    private int port;




    User(String username, String password, int port){
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public User() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
}

}
