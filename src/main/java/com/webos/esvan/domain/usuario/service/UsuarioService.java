package com.webos.esvan.domain.usuario.service;

import java.util.List;

import com.webos.esvan.domain.usuario.Usuario;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Long id);

    Usuario saveUsuario(Usuario usuario);
    
    void deleteUsuario(Long id);

    String verify(Usuario user);

    Usuario register(Usuario user);
}
