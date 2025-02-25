package br.edu.uniacademia.AulaExemplo.controller;

import br.edu.uniacademia.AulaExemplo.AulaExemploApplication;
import br.edu.uniacademia.AulaExemplo.model.Aluno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class AlunoController {

    @GetMapping("/ola")
    public String RetornaOla(){
        return "Olá Pessoal";
    }

    @GetMapping("/aluno")
    public Aluno getAluno(){
        Aluno alu = new Aluno("Jefin", 9 , 7);
        return  alu;
    }

    @GetMapping("/aluno/all")
    public ArrayList<Aluno> getAlunos(){
          return AulaExemploApplication.alunos;
    }

    @GetMapping("/aluno/maior")
    public Aluno getAlunoMaior(){
        Aluno aux = AulaExemploApplication.alunos.get(0);
        for( Aluno a : AulaExemploApplication.alunos ){
            if (a.getNota() > aux.getNota()){
                aux = a;
            }
        }
        return  aux;
    }


}
