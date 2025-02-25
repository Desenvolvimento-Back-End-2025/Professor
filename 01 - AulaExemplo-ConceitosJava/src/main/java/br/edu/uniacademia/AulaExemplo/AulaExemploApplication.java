package br.edu.uniacademia.AulaExemplo;

import br.edu.uniacademia.AulaExemplo.model.Aluno;
import br.edu.uniacademia.AulaExemplo.model.Disciplina;
import br.edu.uniacademia.AulaExemplo.model.Professor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class AulaExemploApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AulaExemploApplication.class, args);
	}

	public static ArrayList<Aluno> alunos = new ArrayList<>();

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bem vindo");
		Aluno alu1 = new Aluno("Zezin da Silva",18, 9);
		Aluno alu2 = new Aluno("Pedrin Miguel",20,4);
		Aluno alu3 = new Aluno("Gustin Oliveto",17,7);
		alunos.add(alu1);
		alunos.add(alu2);
		alunos.add(alu3);
		System.out.println("Alunos Adicionados com sucesso!");

//		System.out.println( alu.getNome() + " "+alu.getNota() );
//		alu.setNota( 8 );
//		System.out.println( alu.getNome() + " "+alu.getNota() );
//
//		System.out.println("O aluno "+alu.getNome() + " está "
//				+ alu.estaAprovado());
//
//		Professor p = new Professor("Gustin", 250);
//		System.out.println(p.getNome()+" - R$ "+p.getSalario());
//
//		Disciplina d = new Disciplina("Back end", 4);
//		d.setProfessor(p);
//		d.getAlunos().add(alu);
//		System.out.println("Disciplina: "+d.getNome()
//				+" nome do professor : "+d.getProfessor().getNome()+
//				" aluno : "+d.getAlunos().get(0).getNome());

	}
}
