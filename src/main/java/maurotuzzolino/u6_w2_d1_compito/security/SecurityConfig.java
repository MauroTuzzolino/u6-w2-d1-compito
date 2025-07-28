package maurotuzzolino.u6_w2_d1_compito.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Serve per abilitare la configurazione di Spring Security
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Disabilito form login e CSRF (non usati in API REST)
        httpSecurity.formLogin(formLogin -> formLogin.disable());
        httpSecurity.csrf(csrf -> csrf.disable());

        // Stato senza sessioni (stateless), perché usiamo JWT
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Per ora apro tutti gli endpoint (poi aggiungeremo restrizioni)
        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("/**").permitAll());

        return httpSecurity.build();
    }
}
