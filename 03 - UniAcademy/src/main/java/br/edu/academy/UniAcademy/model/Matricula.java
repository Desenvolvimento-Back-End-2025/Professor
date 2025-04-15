package br.edu.academy.UniAcademy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ano;
    private int semestre;
    private double nota;
    private int frequencia;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Disciplina disciplina;
//    @ManyToOne
//    private Professor professor;


}
