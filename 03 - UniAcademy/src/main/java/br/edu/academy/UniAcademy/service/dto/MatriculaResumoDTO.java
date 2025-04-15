package br.edu.academy.UniAcademy.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaResumoDTO {

    private int ano, semestre;
    private String nomeAluno, nomeProfessor, disciplina;
    private String status;

}
