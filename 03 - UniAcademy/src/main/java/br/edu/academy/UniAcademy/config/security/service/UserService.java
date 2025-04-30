package br.edu.academy.UniAcademy.config.security.service;

import br.edu.academy.UniAcademy.config.security.model.UsuarioLogado;
import br.edu.academy.UniAcademy.model.Aluno;
import br.edu.academy.UniAcademy.model.Professor;
import br.edu.academy.UniAcademy.model.repository.AlunoRepository;
import br.edu.academy.UniAcademy.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    AlunoRepository arepo;
    @Autowired
    ProfessorRepository prepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Aluno alu = arepo.findByLogin(username);
        if (alu != null) {
//            return new User(alu.getLogin(),alu.getSenha()
//                    , List.of(new SimpleGrantedAuthority("ROLE_ALUNO"))
//            );
            return new UsuarioLogado(alu.getId(),alu.getEmail(), alu.getNome(),
                    alu.getLogin(),alu.getSenha(),
                    List.of(new SimpleGrantedAuthority("ROLE_ALUNO"))
            );

        }else{
            Professor prof = prepo.findByLogin(username);
            if (prof != null) {
                List<GrantedAuthority> lista =
                        List.of(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
                if (prof.getAdmin()){
                    lista = List.of(
                            new SimpleGrantedAuthority("ROLE_PROFESSOR"),
                            new SimpleGrantedAuthority("ROLE_ADMIN"));
                }
//                return new User(prof.getLogin(),prof.getSenha()
//                 , lista
//                );

                return new UsuarioLogado(prof.getId(),prof.getEmail(), prof.getNome(),
                        prof.getLogin(),prof.getSenha(),
                        lista);
            }
            else{
                throw new UsernameNotFoundException(username);
            }
        }
    }
}
