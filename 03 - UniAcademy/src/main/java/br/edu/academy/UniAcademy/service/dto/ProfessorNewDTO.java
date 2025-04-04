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
        return new Professor(0,nome,email,salario);
    }
}
