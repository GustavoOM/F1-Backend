package SCC0541.F1Backend.security;

import SCC0541.F1Backend.dtos.TokenDTO;
import SCC0541.F1Backend.models.DriverModel;
import SCC0541.F1Backend.models.UsuarioModel;
import SCC0541.F1Backend.repositories.ConstructorRepository;
import SCC0541.F1Backend.repositories.DriverRepository;
import SCC0541.F1Backend.services.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    private final UsuarioService usuarioService;

    private final DriverRepository driverRepository;
    private final ConstructorRepository constructorRepository;


    public TokenDTO getToken(UsuarioModel usuarioModel) {

        Date now = new Date();

        Date exp = new Date(now.getTime() + Long.valueOf(expiration));

        // poderá ser :'Administrador', 'Escuderia' OU 'Piloto'
        List<String> listaDeCargos = List.of(usuarioModel.getTipo());

        int id = usuarioModel.getUserId();

        Integer idOriginal = usuarioModel.getIdOriginal() != null ? usuarioModel.getIdOriginal() : null;

        String usuarioLogado = recuperarNomeUsuarioLogado(usuarioModel.getIdOriginal(), listaDeCargos);

        String token = Jwts.builder()
                .setIssuer("F1-Backend")
                .claim("id", id)
                .claim("idOriginal", idOriginal)
                .claim("usuarioLogado", usuarioLogado)
                .claim("roles", listaDeCargos)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return new TokenDTO(token, listaDeCargos);
    }

    private String recuperarNomeUsuarioLogado(Integer idOriginal, List<String> listaDeCargos) {

        if(listaDeCargos.contains("Administrador")) {
            return "Administrador";
        } else if (listaDeCargos.contains("Escuderia")) {
            return constructorRepository.findById(idOriginal)
                    .orElseThrow().getName();
        }
        DriverModel driverModel = driverRepository.findById(idOriginal)
                .orElseThrow();
        return  driverModel.getForename() + " " + driverModel.getSurname();
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {

        if (token == null) {
            return null;
        }


        Claims body = recoverBodyFromToken(token);

        Integer idUsuario = body.get("id", Integer.class);


        if (idUsuario != null){

            UsuarioModel usuarioModel = usuarioService
                    .findById(idUsuario)
                    .orElseThrow(
                        () -> new UsernameNotFoundException("Usuário não encontrado!")
                    );

            List<String> roles = body.get("roles", List.class);

            log.info("roles:"+roles.toString());

            List<SimpleGrantedAuthority> rolesGrantedAuthority = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .toList();

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            usuarioModel, null, rolesGrantedAuthority
                    );

            log.info(usernamePasswordAuthenticationToken.toString());

            return usernamePasswordAuthenticationToken;
        }
        return null;
    }

    private Claims recoverBodyFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


}
