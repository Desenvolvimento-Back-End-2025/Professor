package br.edu.academy.UniAcademy.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SecurityResource {

    @GetMapping("/public")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> testePublic(){
        return ResponseEntity.ok("Serviço liberado!!!");
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/public/all")
    public ResponseEntity<?> testePublic1(){
        return ResponseEntity.ok("Mais um Serviço liberado!!!");
    }
    @GetMapping("/view")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> testeAutenticado(){
        return ResponseEntity.ok("Serviço liberado " +
                "para alguém autenticado!!!");
    }

    @GetMapping("/professor")
    @PreAuthorize("hasAnyRole('PROFESSOR', 'ADMIN')")
    public ResponseEntity<?> testeRole(){
        return ResponseEntity.ok("Professor ou admin" +
                " podem usar!!!");
    }


}
