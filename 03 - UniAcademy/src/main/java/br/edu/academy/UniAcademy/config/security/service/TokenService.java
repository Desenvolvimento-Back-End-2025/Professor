package br.edu.academy.UniAcademy.config.security.service;


import br.edu.academy.UniAcademy.config.security.model.UsuarioLogado;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private long expiration;

    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",  ((UsuarioLogado)userDetails).getId());
        claims.put("nome", ((UsuarioLogado)userDetails).getNome());
        claims.put("email", ((UsuarioLogado)userDetails).getEmail());
        claims.put("role", userDetails.getAuthorities().iterator().next().getAuthority());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // 1h
                .signWith(SignatureAlgorithm.HS256, privateKey)
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(privateKey).build()
                .parseClaimsJws(token)
                .getBody();
    }


    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Map<String, Object> getExtras(String token) {
        return getClaims(token);
    }

    public boolean isTokenValid(String token) {
        return !getClaims(token).getExpiration().before(new Date());
    }

    public String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }


}
