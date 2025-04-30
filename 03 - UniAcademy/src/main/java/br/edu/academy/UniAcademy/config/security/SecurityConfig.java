package br.edu.academy.UniAcademy.config.security;

import br.edu.academy.UniAcademy.config.security.filtro.JWTSecurityFilter;
import br.edu.academy.UniAcademy.config.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    //primeira configuração, cryptografia padrão do sistema
    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }

    @Autowired
    private UserService userService;
    @Autowired
    JWTSecurityFilter jwtFilter;

    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    //configurando o tipo de autenticação
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public/**").permitAll()
////                        .requestMatchers("/view/**").authenticated()
////                        .requestMatchers("/professor/**").hasAnyRole("PROFESSOR","ADMIN")
////                        .requestMatchers("/aluno/**").hasRole("ALUNO")
////                        .requestMatchers("/admin/**").hasRole("ADMIN")
////                        .requestMatchers(HttpMethod.POST,"/professor").hasAuthority("CREATE_PROFESSOR")
//                )
               // .httpBasic(Customizer.withDefaults())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(userService)
                .sessionManagement(sessao ->
                        sessao.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

                return http.build();
    }

    //Configuração da Autorização
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails professor = User.withUsername("prof")
//                .password( passwordEncoder().encode("p123") )
//                .roles("PROFESSOR")
//                .build();
//        UserDetails aluno = User.withUsername("aluno")
//                .password( passwordEncoder().encode("a123") )
//                .roles("ALUNO")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password( passwordEncoder().encode("ad123") )
//                .roles("ADMIN","PROFESSOR")
//                .build();
//
//        return new InMemoryUserDetailsManager(professor, aluno, admin);
//    }

}

