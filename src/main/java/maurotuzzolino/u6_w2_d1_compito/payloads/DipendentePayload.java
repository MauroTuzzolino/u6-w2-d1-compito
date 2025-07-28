package maurotuzzolino.u6_w2_d1_compito.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class DipendentePayload {
    @NotBlank
    private String username;

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;

    @NotBlank
    @Email
    private String email;

    private String immagineProfilo;

    public DipendentePayload(String username, String nome, String cognome, String email, String immagineProfilo) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.immagineProfilo = immagineProfilo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImmagineProfilo() {
        return immagineProfilo;
    }

    public void setImmagineProfilo(String immagineProfilo) {
        this.immagineProfilo = immagineProfilo;
    }

    @Override
    public String toString() {
        return "DipendentePayload{" +
                "username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", immagineProfilo='" + immagineProfilo + '\'' +
                '}';
    }
}
