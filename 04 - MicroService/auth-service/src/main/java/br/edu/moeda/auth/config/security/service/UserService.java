package br.edu.moeda.auth.config.security.service;

import br.edu.moeda.auth.config.security.model.UsuarioLogado;
import br.edu.moeda.auth.model.Usuario;
import br.edu.moeda.auth.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UsuarioRepository arepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario alu = arepo.findByLogin(username);
        if (alu != null) {
//            return new User(alu.getLogin(),alu.getSenha()
//                    , List.of(new SimpleGrantedAuthority("ROLE_ALUNO"))
//            );
            return new UsuarioLogado(alu.getId(),alu.getEmail(), alu.getNome(),
                    alu.getLogin(),alu.getSenha(),
                    List.of(new SimpleGrantedAuthority("ROLE_ALUNO"))
            );

        }
                throw new UsernameNotFoundException(username);

    }

}
