package com.minichat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatApiController {
    UserRepository userRepository;
    public ChatApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @PostMapping("/userloggedin")
    public Boolean userLoggedIn(@RequestParam String userName){
            System.out.println(userRepository.getLogginStatus(userName));
        return  userRepository.getLogginStatus(userName);

    }
    // Super simple loggin missing logout function
    @PostMapping("/loggin")
    public int logginUser(@RequestParam String userName , String password){
        String loggin = null;
        int port = 0;
        boolean logginStatus = userRepository.getLogginStatus(userName);
        String testPasword = userRepository.getUserName(userName);
        if(logginStatus == true){
            loggin = "You are already logged in";
        } else if (testPasword.equals(password)) {
            userRepository.setLogginStatus(userName);
            loggin = "You have logged in";
            port = userRepository.getUserPort(userName);
        }else {
            loggin = "Wrong username or password";
        }
        System.out.println(loggin);
        return port;

    }
}
