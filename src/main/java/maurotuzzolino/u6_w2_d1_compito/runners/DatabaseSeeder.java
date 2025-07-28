package maurotuzzolino.u6_w2_d1_compito.runners;

import maurotuzzolino.u6_w2_d1_compito.entities.Utente;
import maurotuzzolino.u6_w2_d1_compito.repositories.DipendenteRepository;
import maurotuzzolino.u6_w2_d1_compito.repositories.PrenotazioneRepository;
import maurotuzzolino.u6_w2_d1_compito.repositories.UtenteRepository;
import maurotuzzolino.u6_w2_d1_compito.repositories.ViaggioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final DipendenteRepository dipendenteRepository;
    private final ViaggioRepository viaggioRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private UtenteRepository utenteRepository;

    public DatabaseSeeder(DipendenteRepository dipendenteRepository,
                          ViaggioRepository viaggioRepository,
                          PrenotazioneRepository prenotazioneRepository,
                          UtenteRepository utenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
        this.viaggioRepository = viaggioRepository;
        this.prenotazioneRepository = prenotazioneRepository;
        this.utenteRepository = utenteRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
//        // Dipendenti
//        Dipendente mario = new Dipendente("m.rossi", "Mario", "Rossi", "mario.rossi@email.com", null);
//        Dipendente giulia = new Dipendente("g.bianchi", "Giulia", "Bianchi", "giulia.bianchi@email.com", null);
//        Dipendente luigi = new Dipendente("l.verdi", "Luigi", "Verdi", "luigi.verdi@email.com", null);
//
//        dipendenteRepository.save(mario);
//        dipendenteRepository.save(giulia);
//        dipendenteRepository.save(luigi);
//
//        // Viaggi
//        Viaggio milano = new Viaggio("Milano", LocalDate.now().plusDays(10), StatoViaggio.IN_PROGRAMMA);
//        Viaggio londra = new Viaggio("Londra", LocalDate.now().minusDays(15), StatoViaggio.COMPLETATO);
//
//        viaggioRepository.save(milano);
//        viaggioRepository.save(londra);
//
//        // Prenotazioni
//        Prenotazione p1 = new Prenotazione(LocalDate.now(), "Finestrino, hotel centrale", mario, milano);
//        Prenotazione p2 = new Prenotazione(LocalDate.now().minusDays(16), "Business class", giulia, londra);
//
//        prenotazioneRepository.save(p1);
//        prenotazioneRepository.save(p2);
//
//        System.out.println("✅ Database inizializzato con dati di esempio.");

        Utente u1 = new Utente("utente1@example.com", "password123");
        Utente u2 = new Utente("utente2@example.com", "mypassword");

        utenteRepository.saveAll(List.of(u1, u2));
        System.out.println("Utenti di test creati.");

    }
}