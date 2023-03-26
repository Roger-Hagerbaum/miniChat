package com.minichat;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/open")
public class testController {
    UserRepository userRepository;

    public testController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/user")
    public boolean checkUser(@RequestParam String userName){

        return userRepository.existsByUsername(userName) ;
    }
}
