package com.webos.esvan.infra.security;

import com.webos.esvan.domain.usuario.Usuario;
import com.webos.esvan.domain.usuario.repository.UsuarioRepository;
import com.webos.esvan.domain.usuario.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

   @Autowired
   private JWTService jwtService;

   @Autowired
   private UsuarioRepository usuarioRepository;

   public JwtFilter() {
   }

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String authHeader = request.getHeader("Authorization");

      if (authHeader != null && authHeader.startsWith("Bearer ")) {
         String token = authHeader.replace("Bearer ", "");

         try {
            String subject = jwtService.getSubject(token);

            if (subject != null && SecurityContextHolder.getContext().getAuthentication() == null) {
               Usuario usuario = usuarioRepository.findByCorreo(subject);

               if (usuario != null && jwtService.validateToken(token, usuario)) {
                  UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                  authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                  SecurityContextHolder.getContext().setAuthentication(authentication);
               }
            }
         } catch (Exception e) {
            logger.error("Error de autenticación: " + e.getMessage(), e);
         }
      }

      filterChain.doFilter(request, response);
   }
}
