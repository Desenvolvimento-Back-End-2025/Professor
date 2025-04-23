package br.edu.academy.UniAcademy.model.repository;

import br.edu.academy.UniAcademy.model.Aluno;
import br.edu.academy.UniAcademy.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    public Aluno findByNome(String nome);

    public Aluno findByLogin(String nome);

}
