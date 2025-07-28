package maurotuzzolino.u6_w2_d1_compito.repositories;

import maurotuzzolino.u6_w2_d1_compito.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByEmail(String email);
}