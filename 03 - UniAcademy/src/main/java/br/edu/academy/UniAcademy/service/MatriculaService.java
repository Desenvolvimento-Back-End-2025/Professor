package br.edu.academy.UniAcademy.service;

import br.edu.academy.UniAcademy.model.Matricula;
import br.edu.academy.UniAcademy.model.repository.MatriculaRepository;
import br.edu.academy.UniAcademy.service.dto.MatriculaResumoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository repo;

    public Set<Integer> getAnos() {
        Set<Integer> anos = repo.getAnosMatricula();

        return anos;
    }

    public List<MatriculaResumoDTO> getMatriculaAtivas(Integer ano) {
        List<Matricula> lista = repo.findByAno(ano);
        List<MatriculaResumoDTO> mr = lista.stream().map(
                (m)->{
                   return new MatriculaResumoDTO(m.getAno(),m.getSemestre(),
                           m.getAluno().getNome(),"",
                           //m.getProfessor().getNome(),
                           m.getDisciplina().getNome(),"APROVADO");
                }
        ).toList();
        return mr;
    }
}
