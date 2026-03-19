package com.duoc.veterinaria.config;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import static com.duoc.veterinaria.config.SecurityConstants.SUPER_SECRET_KEY;
import static com.duoc.veterinaria.config.SecurityConstants.getSigningKey;

import io.jsonwebtoken.Jwts;

@Configuration
public class JWTAuthenticationConfig {

    public String getJWTToken(String username) {

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils

                .commaSeparatedStringToAuthorityList("ROLE_USER");
        Map<String, Object> claims = new HashMap<>();

        claims.put("authorities", grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        String token = Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 1440))
                .and()
                .signWith(getSigningKey(SUPER_SECRET_KEY))
                .compact();
        return "Bearer " + token;

    }

}
