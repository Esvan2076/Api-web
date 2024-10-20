package com.webos.esvan.services;

import com.webos.esvan.entities.UserPrincipal;
import com.webos.esvan.entities.Usuario;
import com.webos.esvan.repositories.UsuarioRepository;
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
      Usuario user = this.repository.findByUsername(username);
      if (user == null) {
         System.out.println("User Not Found");
         throw new UsernameNotFoundException("user not found");
      } else {
         return new UserPrincipal(user);
      }
   }
}
