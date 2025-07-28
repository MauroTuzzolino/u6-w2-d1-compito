package maurotuzzolino.u6_w2_d1_compito.services;

import maurotuzzolino.u6_w2_d1_compito.entities.Utente;
import maurotuzzolino.u6_w2_d1_compito.exceptions.UnauthorizedException;
import maurotuzzolino.u6_w2_d1_compito.payloads.LoginRequest;
import maurotuzzolino.u6_w2_d1_compito.tools.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private JWTTools jwtTools;

    public String checkCredentialsAndGenerateToken(LoginRequest body) {
        // 1. Cerco utente per email
        Utente found = utenteService.findByEmail(body.email());

        // 2. Controllo che la password combaci (NB: qui non è criptata)
        if (found.getPassword().equals(body.password())) {
            // 3. Genero il token JWT
            String accessToken = jwtTools.createToken(found);
            return accessToken;
        } else {
            // 4. Password errata -> eccezione 401
            throw new UnauthorizedException("Credenziali errate!");
        }
    }
}

