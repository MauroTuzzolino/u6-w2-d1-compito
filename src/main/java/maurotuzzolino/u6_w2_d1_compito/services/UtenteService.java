package maurotuzzolino.u6_w2_d1_compito.services;

import maurotuzzolino.u6_w2_d1_compito.entities.Utente;
import maurotuzzolino.u6_w2_d1_compito.exceptions.NotFoundException;
import maurotuzzolino.u6_w2_d1_compito.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository userRepository;

    public Utente findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utente con email " + email + " non trovato!"));
    }

    // Potrai aggiungere altri metodi qui (es. save, delete ecc.)
}
