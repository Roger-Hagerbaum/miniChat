package com.minichat;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/closed")
public class ChatApiController {

    UserRepository userRepository;

    public ChatApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/userloggedin")
    public String userLoggedIn(Authentication authentication) {

        return authentication.getName();

    }

    @PostMapping("/userport")
    public int userPort(@RequestParam String userName) {
        System.out.println(userRepository.getUserPort(userName));
        return userRepository.getUserPort(userName);


    }
}
