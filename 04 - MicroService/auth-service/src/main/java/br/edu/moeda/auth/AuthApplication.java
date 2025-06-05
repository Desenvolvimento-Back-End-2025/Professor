package br.edu.moeda.auth;

import br.edu.moeda.auth.model.Usuario;
import br.edu.moeda.auth.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Autowired
    UsuarioRepository repo;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if (repo.findAll().isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("Administrador");
            admin.setEmail("admin@empresa.com");
            admin.setLogin("admin");
            admin.setSenha(encoder.encode("admin123") );
            admin.setEhAdmin(true);
            repo.save(admin);

            Usuario user = new Usuario();
            user.setNome("Usuário Comum");
            user.setEmail("user@empresa.com");
            user.setLogin("user");
            user.setSenha(encoder.encode("user123"));
            user.setEhAdmin(false);
            repo.save(user);
        }
    }
}
