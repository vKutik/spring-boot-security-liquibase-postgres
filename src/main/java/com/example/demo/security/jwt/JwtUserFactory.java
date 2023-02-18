package com.example.demo.security.jwt;

import com.example.demo.model.Role;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
            user.getStatus().equals(Status.ACTIVE),
            mapToGrantedAuthority(user.getRoles())
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<Role> roles) {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    }
}
