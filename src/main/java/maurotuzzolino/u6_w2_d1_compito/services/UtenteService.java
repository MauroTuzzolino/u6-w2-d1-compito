package maurotuzzolino.u6_w2_d1_compito.services;

import maurotuzzolino.u6_w2_d1_compito.entities.Utente;
import maurotuzzolino.u6_w2_d1_compito.exceptions.NotFoundException;
import maurotuzzolino.u6_w2_d1_compito.payloads.NewUtenteRequest;
import maurotuzzolino.u6_w2_d1_compito.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente findByEmail(String email) {
        return utenteRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utente con email " + email + " non trovato!"));
    }

    public Utente save(NewUtenteRequest body) {
        Utente nuovoUtente = new Utente();
        nuovoUtente.setEmail(body.getEmail());
        nuovoUtente.setPassword(body.getPassword()); // NB: non criptata per semplicità

        return utenteRepository.save(nuovoUtente);
    }
}
