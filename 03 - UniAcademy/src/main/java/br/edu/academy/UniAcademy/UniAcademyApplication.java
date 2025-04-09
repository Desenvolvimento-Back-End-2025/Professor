package br.edu.academy.UniAcademy;

import br.edu.academy.UniAcademy.model.Aluno;
import br.edu.academy.UniAcademy.model.Disciplina;
import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.model.repository.AlunoRepository;
import br.edu.academy.UniAcademy.model.repository.DisciplinaRepository;
import br.edu.academy.UniAcademy.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class UniAcademyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniAcademyApplication.class, args);
	}

	@Autowired
	ProfessorRepository profRepo;
	@Autowired
	AlunoRepository aluRepo;
	@Autowired
	DisciplinaRepository discRepo;

	@Override
	public void run(String... args) throws Exception {
		Professor professor = new Professor();
		professor.setNome("PEdrin");
		professor.setEmail("ped@ped");
		professor.setSalario(800);
		professor.setLogin("ped");
		professor.setSenha("123");
		profRepo.save(professor);

		Aluno alu = new Aluno();
		alu.setNome("Jeffin");
		alu.setEmail("jef@jef");
		alu.setMatricula("123");
		alu.setLogin("jef");
		alu.setSenha("123");
		aluRepo.save(alu);

		Disciplina disc = new Disciplina();
		disc.setCargaHoraria(80);
		disc.setNome("Desenvolvimento Back end");
		disc.setProfessores(new ArrayList<>());
		disc.getProfessores().add(professor);
		discRepo.save(disc);

	}
}
