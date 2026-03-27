package siakad_api.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import siakad_api.utils.JwtUtil;

import java.io.IOException;

public class JwtFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();

        // skip login
        if (path.contains("/login")) {
            chain.doFilter(request, response);
            return;
        }

        String authHeader = req.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            ((HttpServletResponse) response).setStatus(401);
            return;
        }

        try {
            String token = authHeader.replace("Bearer ", "");
            JwtUtil.validateToken(token);

            chain.doFilter(request, response);

        } catch (Exception e) {
            ((HttpServletResponse) response).setStatus(401);
        }
    }
}