package br.edu.academy.UniAcademy.resource;

import br.edu.academy.UniAcademy.config.security.model.UsuarioLogado;
import br.edu.academy.UniAcademy.config.security.service.TokenService;
import br.edu.academy.UniAcademy.config.security.service.UserService;
import br.edu.academy.UniAcademy.service.dto.LoginDTO;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "serviço para obter o token", summary = "LOGAR")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "token obtido com sucesso"),
            @ApiResponse(responseCode = "403", description = "login inválido")
    })
    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login){
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(login.getLogin(), login.getSenha()));

        UserDetails ud = uService.loadUserByUsername(login.getLogin());

        String token = tokenService.generateToken(ud);

        return ResponseEntity.ok(token);
    }

    @Operation(description = "dados do usuário logado", summary = "ME")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados do usuário"),
            @ApiResponse(responseCode = "403", description = "login inválido")
    })
    @GetMapping("/me")
    public ResponseEntity<String> getInfo(Authentication auth){
        System.out.println(auth.getPrincipal());
        return ResponseEntity.ok("nome do usuario: "
                + ((UsuarioLogado)auth.getPrincipal()).getNome()+
                " email : "+((UsuarioLogado)auth.getPrincipal()).getEmail());
    }

}
