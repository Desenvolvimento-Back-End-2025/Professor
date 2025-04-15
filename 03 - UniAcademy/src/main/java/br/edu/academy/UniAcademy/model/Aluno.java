package br.edu.academy.UniAcademy.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno extends Usuario {

    private String matricula;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Matricula> matriculas;

}
