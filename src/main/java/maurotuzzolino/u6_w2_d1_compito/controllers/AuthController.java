package maurotuzzolino.u6_w2_d1_compito.controllers;


import maurotuzzolino.u6_w2_d1_compito.entities.Utente;
import maurotuzzolino.u6_w2_d1_compito.exceptions.ValidationException;
import maurotuzzolino.u6_w2_d1_compito.payloads.*;
import maurotuzzolino.u6_w2_d1_compito.services.AuthService;
import maurotuzzolino.u6_w2_d1_compito.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest body) {
        String accessToken = authService.checkCredentialsAndGenerateToken(body);
        return new LoginResponse(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUtenteResponse register(@RequestBody @Validated NewUtenteRequest payload,
                                      BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(
                    validationResult.getFieldErrors()
                            .stream()
                            .map(error -> error.getDefaultMessage())
                            .toList()
            );
        } else {
            Utente newUtente = utenteService.save(payload);
            return new NewUtenteResponse(newUtente.getId());
        }
    }

    @GetMapping("/me")
    public CurrentUtenteResponse getCurrentUtente() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Utente currentUtente = (Utente) authentication.getPrincipal();

        return new CurrentUtenteResponse(
                currentUtente.getId(),
                currentUtente.getEmail(),
                currentUtente.getPassword()
        );
    }
}
