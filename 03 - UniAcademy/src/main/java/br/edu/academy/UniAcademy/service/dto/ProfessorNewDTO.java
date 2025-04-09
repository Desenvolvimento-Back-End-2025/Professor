package br.edu.academy.UniAcademy.service.dto;

import br.edu.academy.UniAcademy.model.Professor;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfessorNewDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    private String nome;
    @NotNull
    @Email
    private String email;
    @Min(0)
    @NotNull
    private double salario;

    public Professor create() {
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setEmail(this.email);
        professor.setSalario(this.salario);
        return professor;
    }
}
