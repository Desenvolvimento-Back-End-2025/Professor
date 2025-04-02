package br.edu.academy.UniAcademy.resource;


import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.service.ProfessorService;
import br.edu.academy.UniAcademy.service.dto.ProfessorListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
