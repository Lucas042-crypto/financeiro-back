package br.com.yonkoudev.financeiro.config.cors;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterConfig implements Filter {

    protected Set<String> allowedOrigins = new HashSet<>(List.of("http://localhost:4200"));

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Credentials", "true");

        String originRequest = request.getHeader("Origin");

        boolean originPermitido = allowedOrigins.contains(originRequest);

        if (originPermitido) {
            response.setHeader("Access-Control-Allow-Origin", originRequest);
        }

        if ("OPTIONS".equals(request.getMethod()) && originPermitido) {
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
