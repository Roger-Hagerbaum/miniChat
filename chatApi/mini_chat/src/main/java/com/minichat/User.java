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
    private String userName;
    private  String password;
    private int port;

    User(){}

    User(String userName, String password, int port){
        this.userName = userName;
        this.password = password;
        this.port = port;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
