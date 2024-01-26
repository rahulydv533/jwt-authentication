package com.jwt.jwtauthenticationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication()
public class JwtAuthenticationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationServerApplication.class, args);
    }

}
