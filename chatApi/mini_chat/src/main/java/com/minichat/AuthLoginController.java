package com.minichat;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthLoginController {

    private final Token token;

    public AuthLoginController(Token token) {
        this.token = token;
    }


    @PostMapping("/token")
    public String token(Authentication authentication) {
        return token.generateToken(authentication);
    }

}
