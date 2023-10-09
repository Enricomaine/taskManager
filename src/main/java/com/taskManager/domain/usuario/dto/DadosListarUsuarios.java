package com.taskManager.domain.usuario.dto;

import com.taskManager.domain.usuario.Roles;
import com.taskManager.domain.usuario.Usuario;

public record DadosListarUsuarios(String username, Roles roles) {

    public DadosListarUsuarios (Usuario usuario) {
        this(usuario.getUsername(), usuario.getRole());
    }
}
