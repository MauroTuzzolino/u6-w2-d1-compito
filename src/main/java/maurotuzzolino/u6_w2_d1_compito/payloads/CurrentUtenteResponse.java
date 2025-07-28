package maurotuzzolino.u6_w2_d1_compito.payloads;


public record CurrentUtenteResponse(
        Long id,
        String email,
        String password
) {
}