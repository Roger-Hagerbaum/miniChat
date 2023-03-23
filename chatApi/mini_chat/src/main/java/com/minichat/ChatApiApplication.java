package com.minichat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
public class ChatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository users , PasswordEncoder encoder) {
		return args -> {
			users.save(new User("Jack",encoder.encode("pass1"),77));
			users.save(new User("Tess",encoder.encode("pass2"),88));
		};
	}

}
