package br.edu.academy.UniAcademy.resource;

import br.edu.academy.UniAcademy.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaResource {

    @Autowired
    MatriculaService service;
    @GetMapping("/anos")
    public ResponseEntity<?> getAnosMatricula() {
        return ResponseEntity.ok(service.getAnos());
    }

    @GetMapping("/ativas/{ano}")
    public ResponseEntity<?> getMatriculasAtivas(@PathVariable Integer ano) {

        return ResponseEntity.ok(service.getMatriculaAtivas(ano));
    }


}
