package maurotuzzolino.u6_w2_d1_compito.payloads;

public class NewUtenteResponse {
    private Long id;

    public NewUtenteResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}