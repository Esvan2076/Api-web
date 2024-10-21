package com.webos.esvan.domain.usuario.service;

import com.webos.esvan.domain.usuario.UserPrincipal;
import com.webos.esvan.domain.usuario.Usuario;
import com.webos.esvan.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
   @Autowired
   private UsuarioRepository repository;

   public MyUserDetailsService() {
   }

   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario user = this.repository.findByNombreUsuario(username);
      if (user == null) {
         System.out.println("User Not Found");
         throw new UsernameNotFoundException("user not found");
      } else {
         return new UserPrincipal(user);
      }
   }
}
