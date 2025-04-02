package br.edu.academy.UniAcademy.service;

import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.model.repository.ProfessorRepository;
import br.edu.academy.UniAcademy.service.dto.ProfessorListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository profRepo;

    public List<ProfessorListDTO> getProfessores() {
        List<Professor> lista = profRepo.findAll();
        List<ProfessorListDTO> listaDTO = new ArrayList<>();

        listaDTO = lista.stream().map( p -> {
            return new ProfessorListDTO(p.getId(),p.getNome(),p.getEmail());
        } ).toList();

//        for (Professor p : lista) {
//            listaDTO.add(new ProfessorListDTO(p.getId(),p.getNome(),p.getEmail()));
//        }

        return listaDTO;
    }
}
