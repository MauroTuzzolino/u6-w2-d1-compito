package maurotuzzolino.u6_w2_d1_compito.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import maurotuzzolino.u6_w2_d1_compito.exceptions.UnauthorizedException;
import maurotuzzolino.u6_w2_d1_compito.tools.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTCheckerFilter extends OncePerRequestFilter {

    @Autowired
    private JWTTools jwtTools;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Recupero header Authorization
        String authHeader = request.getHeader("Authorization");

        // 2. Verifico presenza e formato Bearer token
        if (authHeader == null || !authHeader.startsWith("Bearer "))
            throw new UnauthorizedException("Inserire il token nell'Authorization Header nel formato corretto!");

        // 3. Estraggo il token togliendo il prefisso Bearer
        String accessToken = authHeader.replace("Bearer ", "");

        // 4. Verifico il token
        jwtTools.verifyToken(accessToken);

        // 5. Se tutto OK
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return new AntPathMatcher().match("/auth/**", request.getServletPath());
    }
}
