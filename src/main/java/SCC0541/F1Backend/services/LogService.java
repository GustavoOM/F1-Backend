package SCC0541.F1Backend.services;

import SCC0541.F1Backend.repositories.LogRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Value("${jwt.secret}")
    String secret;

    public void createLog(String token) {
        if(token != null) {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            if(body != null){
                Integer id = Integer.parseInt(body.get("id").toString());
                Integer idOriginal = null;
                if(body.get("idOriginal") != null){
                    if( body.get("idOriginal") instanceof Integer){
                        idOriginal = Integer.parseInt(body.get("idOriginal").toString());
                    }
                }
                // tenta inserir o log no banco!
                logRepository.createLog(id, idOriginal);
                log.info("Log inserido no banco!");

            }
        }
    }
}