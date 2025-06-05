package br.edu.moeda.auth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private int id;
    @Column(nullable = false,length = 70)
    private String nome;
    @Column(nullable = false,length = 30,unique = true)
    private String login;
    @Column(nullable = false,length = 70)
    private String senha;
    @Column(unique = true, nullable = false)
    private String email;
    private boolean ehAdmin;
}
