package com.webos.esvan.domain.usuario.service;

import java.util.List;

import com.webos.esvan.infra.security.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webos.esvan.domain.usuario.Usuario;
import com.webos.esvan.domain.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
   

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public String verify(Usuario user) {
        Authentication authentication = this.authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getNombreUsuario(), user.getContrasena()));
        return authentication.isAuthenticated() ? this.jwtService.generateToken(user) : "fail";
    }

    public Usuario register(Usuario user) {
        user.setContrasena(this.encoder.encode(user.getContrasena()));
        this.usuarioRepository.save(user);
        return user;
     }
}
