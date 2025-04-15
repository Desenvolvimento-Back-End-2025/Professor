package br.edu.academy.UniAcademy.model.repository;

import br.edu.academy.UniAcademy.model.Aluno;
import br.edu.academy.UniAcademy.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    //JPQL
    @Query("select distinct m.ano from Matricula m")
    Set<Integer> getAnosMatricula();

    List<Matricula> findByAno(Integer ano);


}
