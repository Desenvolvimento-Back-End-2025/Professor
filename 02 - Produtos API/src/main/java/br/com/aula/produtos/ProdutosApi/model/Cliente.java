package br.com.aula.produtos.ProdutosApi.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private int id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String nome;
    @Past
    private LocalDate dataNascimento;
    @Min(1500)
    private double salario;
    private ArrayList<Produto> produtos;


    public int idade() {
        LocalDate dtAtual = LocalDate.now();
        return dtAtual.getYear() - dataNascimento.getYear();
    }
}
