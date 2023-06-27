package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.LoginDTO;
import SCC0541.F1Backend.dtos.UsuarioRespostaDTO;
import SCC0541.F1Backend.models.UsuarioModel;
import SCC0541.F1Backend.repositories.UsuarioRepository;
import SCC0541.F1Backend.services.ConstructorService;
import SCC0541.F1Backend.services.DriverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;


    // DEVEMOS CONFIGURAR QUE APENAS O ADMIN TEM ACESSO A ESSE ENDPOINT
    public List<UsuarioRespostaDTO> listarUsuariosDoSistemaPorTipo(String tipoPessoa) {


        return usuarioRepository.listarUsuariosDoSistemaPorTipo(tipoPessoa)
                .stream()
                .map(usuarioEntity -> {
                    UsuarioRespostaDTO usuarioRespostaDTO = new UsuarioRespostaDTO();
                    usuarioRespostaDTO.setLogin(usuarioEntity.getUsername());
                    usuarioRespostaDTO.setTipo(usuarioEntity.getTipo());
                    return usuarioRespostaDTO;
                })
                .toList();
    }

    public List<UsuarioRespostaDTO> listarUsuariosDoSistema() {
        return usuarioRepository.listarUsuariosDoSistema()
                .stream()
                .map(usuarioEntity -> {
                    UsuarioRespostaDTO usuarioRespostaDTO = new UsuarioRespostaDTO();
                    usuarioRespostaDTO.setLogin(usuarioEntity.getUsername());
                    usuarioRespostaDTO.setTipo(usuarioEntity.getTipo());
                    return usuarioRespostaDTO;
                })
                .toList();
    }


    public Optional<UsuarioModel> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public Optional<UsuarioModel> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
}
