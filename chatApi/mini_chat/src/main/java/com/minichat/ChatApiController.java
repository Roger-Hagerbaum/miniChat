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

        return  userRepository.getLogginStatus(userName);

    }
    // Super simple loggin missing logout function
    @PostMapping("/loggin")
    public String logginUser(@RequestParam String userName , String password){
        String loggin = null;
        boolean logginStatus = userRepository.getLogginStatus(userName);
        String testPasword = userRepository.getUserName(userName);
        if(logginStatus == true){
            loggin = "You are already logged in";
        } else if (testPasword.equals(password)) {
            userRepository.setLogginStatus(userName);
            loggin = "You have logged in";
        }else {
            loggin = "Wrong username or password";
        }
        System.out.println(loggin);
        return loggin;

    }

     @PostMapping("/user")
     public int getUserPort(@RequestParam String userName) {
        int test = userRepository.getUserPort(userName);
        return test ;
    }
  
}
