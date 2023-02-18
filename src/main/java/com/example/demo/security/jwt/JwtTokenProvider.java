package com.example.demo.security.jwt;

import com.example.demo.model.Role;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expired}")
    private Long validationTime;

    private UserDetailsService userDetailsService;

    public JwtTokenProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(String username, List<Role> roles) {
        return null;
    }

    public Authentication getAuthentication(String token) {
        return null;
    }

    public String getUserName(String token) {
        return null;
    }

    public boolean validateToken(String token) {

        return false;
    }

    private List<String> getRoleNames(List<Role> userRoles) {
        return userRoles
            .stream()
            .map(role -> role.getName())
            .collect(Collectors.toList());
    }
}
