package br.edu.moeda.auth.model.repository;


import br.edu.moeda.auth.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByNome(String nome);

    public Usuario findByLogin(String nome);

}
