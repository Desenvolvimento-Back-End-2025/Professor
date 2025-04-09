package br.edu.academy.UniAcademy.model.repository;

import br.edu.academy.UniAcademy.model.Aluno;
import br.edu.academy.UniAcademy.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {


}
