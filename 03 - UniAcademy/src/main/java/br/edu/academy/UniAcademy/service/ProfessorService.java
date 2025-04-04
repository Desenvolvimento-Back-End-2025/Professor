package br.edu.academy.UniAcademy.service;

import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.model.repository.ProfessorRepository;
import br.edu.academy.UniAcademy.service.dto.ProfessorListDTO;
import br.edu.academy.UniAcademy.service.dto.ProfessorNewDTO;
import jakarta.validation.Valid;
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

    public void save(@Valid ProfessorNewDTO prof) throws Exception {
        if (!prof.getNome().contains(" ")){
            throw new Exception("O nome deve conter um sobrenome");
        }
        Professor p = prof.create();
        profRepo.save(p);
    }

    public void delete(Integer id) throws Exception {
//        Professor p = profRepo.findById(id).get();
//        if (p == null){
//            throw new Exception("professor "+id+" não existe");
//        }
        ProfessorListDTO p = getProfessor(id);
        profRepo.deleteById(p.getId());
    }

    public ProfessorListDTO getProfessor(Integer id) throws Exception {
        Professor p = profRepo.findById(id).get();
        if (p == null){
            throw new Exception("professor "+id+" não existe");
        }
        return new ProfessorListDTO(p.getId(),p.getNome(),p.getEmail());
    }

    public List<ProfessorListDTO> getProfessorSalario(Double sal) throws Exception {
        List<Professor> lista = profRepo.findBySalarioIsGreaterThan(sal);
        if(lista.isEmpty()){
            throw new Exception("lista vazia");
        }
        List<ProfessorListDTO> listaDTO = new ArrayList<>();

        listaDTO = lista.stream().map( p -> {
            return new ProfessorListDTO(p.getId(),p.getNome(),p.getEmail());
        } ).toList();
        return listaDTO;
    }
}
