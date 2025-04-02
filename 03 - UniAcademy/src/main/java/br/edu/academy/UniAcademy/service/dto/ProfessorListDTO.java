package br.edu.academy.UniAcademy.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorListDTO {

    private int id;
    private String nome;
    private String email;

}
