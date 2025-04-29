package br.edu.academy.UniAcademy;

import br.edu.academy.UniAcademy.model.Aluno;
import br.edu.academy.UniAcademy.model.Disciplina;
import br.edu.academy.UniAcademy.model.Matricula;
import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.model.repository.AlunoRepository;
import br.edu.academy.UniAcademy.model.repository.DisciplinaRepository;
import br.edu.academy.UniAcademy.model.repository.MatriculaRepository;
import br.edu.academy.UniAcademy.model.repository.ProfessorRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

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
	@Autowired
	MatriculaRepository mateRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {



		Professor professor = new Professor();
		professor.setNome("PEdrin");
		professor.setEmail("ped@ped");
		professor.setSalario(800);
		professor.setLogin("ped");
		professor.setSenha( passwordEncoder.encode("123") );
		professor.setAdmin(true);
		profRepo.save(professor);

		Aluno alu = new Aluno();
		alu.setNome("Jeffin");
		alu.setEmail("jef@jef");
		alu.setMatricula("123");
		alu.setLogin("jef");
		alu.setSenha(passwordEncoder.encode("123") );
		aluRepo.save(alu);

		Disciplina disc = new Disciplina();
		disc.setCargaHoraria(80);
		disc.setNome("Desenvolvimento Back end");
		disc.setProfessores(new ArrayList<>());
		disc.getProfessores().add(professor);
		discRepo.save(disc);

		Matricula mat = new Matricula(0,2025,
				1,10,10,alu,disc);
//				professor);
		mateRepo.save(mat);


	}
}
