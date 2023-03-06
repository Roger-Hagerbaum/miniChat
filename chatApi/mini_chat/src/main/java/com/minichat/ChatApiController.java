package com.minichat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatApiController {
    UserRepository userRepository;

    public ChatApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


     @PostMapping("/user")
     public @ResponseBody Iterable<User> getUser(@RequestParam String userName) {
        
        return userRepository.findByuserName(userName);
    }
  
}
