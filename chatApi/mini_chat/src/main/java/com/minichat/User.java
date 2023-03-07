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
    private boolean loggin;

    User(){}

    User(String userName, String password, int port, boolean loggin){
        this.userName = userName;
        this.password = password;
        this.port = port;
        this.loggin = loggin;
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
    public boolean getloggin() {return loggin;}
    public void setloggin(boolean loggin) {
        loggin = loggin;
    }

}
