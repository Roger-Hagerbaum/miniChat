package com.minichat;

import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/open")
public class OpenController {
    UserRepository userRepository;
    PasswordEncoder encoder;
    public OpenController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    @GetMapping("/user")
    public boolean checkUser(@RequestParam String userName){

        return userRepository.existsByUsername(userName) ;
    }

    @PostMapping("/register")
    public User newUser(@RequestParam String userName , String password){

        int port = (int) (88 + userRepository.countByUsername(userName));
        return userRepository.save(new User(userName,encoder.encode(password),port));
    }
}
