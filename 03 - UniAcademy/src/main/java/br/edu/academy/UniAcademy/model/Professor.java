package br.edu.academy.UniAcademy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor extends Usuario {

    private double salario;
    @ManyToMany
    List<Disciplina> disciplinas;

}
