package com.axonactive.coffeeshopmanagement.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private List<String> roles;

    public JwtResponse(String jwt, String username, List<String> roles) {
        this.roles = roles;
        this.token = jwt;
        this.username = username;
    }
}
