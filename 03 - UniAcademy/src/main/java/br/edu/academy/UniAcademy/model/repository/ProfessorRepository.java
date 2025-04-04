package br.edu.academy.UniAcademy.model.repository;

import br.edu.academy.UniAcademy.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    public List<Professor> findBySalarioIsGreaterThan(Double sal);

}
