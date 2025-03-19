package br.com.aula.produtos.ProdutosApi;

import br.com.aula.produtos.ProdutosApi.model.Cliente;
import br.com.aula.produtos.ProdutosApi.model.Produto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class ProdutosApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApiApplication.class, args);
	}

	public static ArrayList<Produto> produtos= new ArrayList<>();
	public static ArrayList<Cliente> clientes= new ArrayList<>();

	@Override
	public void run(String... args) throws Exception {

		clientes.add(new Cliente(1,"Zezin da Silva",
				LocalDate.of(2000,5,18), 800, null));
		clientes.add(new Cliente(2,"Gustin Manuel",
				LocalDate.of(1950,11,25), 18000, null));

		Produto prod = new Produto(1, "Tecaldo PS2", "teclado para game",
				10, 5, 12,
				1000, 25, true);
		produtos.add(prod);
		produtos.add(new Produto(2, "Mouse motospeed", "mouse para game",
				20, 10, 20,
				150, 50, true));
		produtos.add(new Produto(3, "Notebook Acer Nitro 7", "notebook para game",
				5, 5, 8,
				5000, 30, false));

		System.out.println("Servidor iniciado com sucesso!");

	}
}
