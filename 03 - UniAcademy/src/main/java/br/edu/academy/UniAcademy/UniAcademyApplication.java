package br.edu.academy.UniAcademy;

import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniAcademyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniAcademyApplication.class, args);
	}

	@Autowired
	ProfessorRepository profRepo;

	@Override
	public void run(String... args) throws Exception {
		Professor professor = new Professor(0,"Zezin","ze@ze",1000);
		profRepo.save(professor);
		Professor professor1 = new Professor(0,"Pedrin","ped@ped",800);
		profRepo.save(professor1);
		Professor professor2 = new Professor(0,"Gustin","gu@gu",800);
		profRepo.save(professor2);

	}
}
