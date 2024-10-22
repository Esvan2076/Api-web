package com.webos.esvan.domain.usuario;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
   private Usuario user;

   public UserPrincipal(Usuario user) {
      this.user = user;
   }

   public Collection<? extends GrantedAuthority> getAuthorities() {
      return Collections.singleton(new SimpleGrantedAuthority("USER"));
   }

   public String getPassword() {
      return this.user.getContrasena();
   }

   public String getCorreo() {
      return this.user.getCorreo();
   }

   public String getUsername() {
      return this.user.getNombreUsuario();
   }

   public boolean isAccountNonExpired() {
      return true;
   }

   public boolean isAccountNonLocked() {
      return true;
   }

   public boolean isCredentialsNonExpired() {
      return true;
   }

   public boolean isEnabled() {
      return true;
   }
}
