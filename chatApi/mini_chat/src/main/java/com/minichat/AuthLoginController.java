package com.minichat;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/auth")
public class AuthLoginController {

    private final Token token;
    private final UserRepository userRepository;

    public AuthLoginController(Token token, UserRepository userRepository) {
        this.token = token;
        this.userRepository = userRepository;
    }


    @PostMapping("/token")
    public String token(Authentication authentication) {
        String returnString;

        int port = userRepository.getUserPort(authentication.getName());

        returnString = token.generateToken(authentication) +";;"+ port;
        return returnString;
    }

}
