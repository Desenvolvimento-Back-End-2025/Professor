package br.edu.academy.UniAcademy.resource;


import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.service.ProfessorService;
import br.edu.academy.UniAcademy.service.dto.ProfessorListDTO;
import br.edu.academy.UniAcademy.service.dto.ProfessorNewDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorResource {
    @Autowired
    ProfessorService profService;

    @GetMapping("")
    public ResponseEntity<?> getProfesores(){
        List<ProfessorListDTO> lista = profService.getProfessores();
        return ResponseEntity.ok( lista );
    }

    @PostMapping("")
    public ResponseEntity<?>
            saveProfessor( @Valid @RequestBody ProfessorNewDTO prof){
        try {
            profService.save(prof);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable Integer id){
        try {
            profService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessorById(@PathVariable Integer id){
        ProfessorListDTO prof = null;
        try {
            prof = profService.getProfessor(id);
            return ResponseEntity.ok(prof);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/salario/{sal}")
    public ResponseEntity<?> getProfessorBySalario(@PathVariable Double sal){
        List<ProfessorListDTO> profs = null;
        try {
            profs = profService.getProfessorSalario(sal);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profs);
    }



}
