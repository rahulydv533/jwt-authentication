package com.jwt.jwtauthenticationserver.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JWTRequest {
    private String username;
    private String password;
}
