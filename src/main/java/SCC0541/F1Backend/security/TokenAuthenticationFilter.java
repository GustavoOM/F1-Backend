package SCC0541.F1Backend.security;

import SCC0541.F1Backend.services.LogService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final LogService logService;

    public static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = getTokenFromHeader(request);


        logService.createLog(token);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                tokenService.isValid(token);

        SecurityContextHolder.getContext().
                setAuthentication(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken != null && usernamePasswordAuthenticationToken.isAuthenticated()) {
            // Obtenha as roles do token
            Collection<? extends GrantedAuthority> authorities = usernamePasswordAuthenticationToken.getAuthorities();

            // Adicione um log para verificar as roles
            if (authorities != null) {
                List<String> roles = authorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());
                log.info("Roles: " + roles);
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }
        return token.replace(BEARER, "");
    }
}
