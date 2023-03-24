package com.minichat;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
public class ChatApiController {

     UserRepository userRepository;

    public ChatApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/userloggedin")
    public String userLoggedIn(Authentication authentication){
    String test = authentication.getName();
        return test;

    }

    @PostMapping("/userport")
    public int userPort(@RequestParam String userName){
        System.out.println(userRepository.getUserPort(userName));
        return userRepository.getUserPort(userName);

    }

}
