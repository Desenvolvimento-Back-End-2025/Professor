package br.edu.academy.UniAcademy.resource;

import br.edu.academy.UniAcademy.config.security.model.UsuarioLogado;
import br.edu.academy.UniAcademy.config.security.service.TokenService;
import br.edu.academy.UniAcademy.config.security.service.UserService;
import br.edu.academy.UniAcademy.service.dto.LoginDTO;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService uService;

    @Autowired
    TokenService tokenService;

    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login){
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(login.getLogin(), login.getSenha()));

        UserDetails ud = uService.loadUserByUsername(login.getLogin());

        String token = tokenService.generateToken(ud);

        return ResponseEntity.ok(token);
    }

    @GetMapping("/me")
    public ResponseEntity<String> getInfo(Authentication auth){
        System.out.println(auth.getPrincipal());
        return ResponseEntity.ok("nome do usuario: "
                + ((UsuarioLogado)auth.getPrincipal()).getNome()+
                " email : "+((UsuarioLogado)auth.getPrincipal()).getEmail());
    }

}
