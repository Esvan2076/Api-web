package com.webos.esvan.services;

import java.util.List;

import com.webos.esvan.entities.Usuario;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Long id);

    Usuario saveUsuario(Usuario usuario);
    
    void deleteUsuario(Long id);
}
