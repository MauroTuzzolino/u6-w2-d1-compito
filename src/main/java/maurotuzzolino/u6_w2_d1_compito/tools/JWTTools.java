package maurotuzzolino.u6_w2_d1_compito.tools;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import maurotuzzolino.u6_w2_d1_compito.entities.Utente;
import maurotuzzolino.u6_w2_d1_compito.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {

    @Value("${jwt.secret}")
    private String secret;

    public String createToken(Utente user) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .setSubject(String.valueOf(user.getId()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    public void verifyToken(String accessToken) {
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(accessToken);
        } catch (Exception ex) {
            throw new UnauthorizedException("Problemi con il token! Effettuare di nuovo il login!");
        }
    }
}
