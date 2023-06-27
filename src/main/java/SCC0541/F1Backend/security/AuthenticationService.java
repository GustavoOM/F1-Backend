package SCC0541.F1Backend.security;

import SCC0541.F1Backend.models.UsuarioModel;
import SCC0541.F1Backend.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService implements UserDetailsService {

    private final UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        log.info("Recuperando o login :" + login + " no banco");

        Optional<UsuarioModel> usuarioOptional = usuarioService.findByLogin(login);


        return usuarioOptional.orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado!")
        );

    }
}
