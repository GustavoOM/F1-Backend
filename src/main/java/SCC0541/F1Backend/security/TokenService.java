package SCC0541.F1Backend.security;

import SCC0541.F1Backend.models.UsuarioModel;


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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    private final UsuarioService usuarioService;

    public String getToken(UsuarioModel usuarioModel) {

        Date now = new Date();

        Date exp = new Date(now.getTime() + Long.valueOf(expiration));

        // poderá ser :'Administrador', 'Escuderia' OU 'Piloto'
        List<String> listaDeCargos = List.of(usuarioModel.getTipo());

        String token = Jwts.builder()
                .setIssuer("F1-Backend")
                .claim("id", usuarioModel.getUserId())
                .claim("originalId", usuarioModel.getIdOriginal())
                .claim("roles", listaDeCargos)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return "Bearer " + token;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {

        if (token == null) {
            return null;
        }

        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Integer idUsuario = body.get("id", Integer.class);
        Integer originalIdUsuario = body.get("originalId", Integer.class);

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


}
