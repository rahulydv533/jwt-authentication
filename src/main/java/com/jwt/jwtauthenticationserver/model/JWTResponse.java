package com.jwt.jwtauthenticationserver.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JWTResponse {
    private String jwtToken;
    private String username;
}
