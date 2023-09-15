package com.taskManager.usuario;

import com.taskManager.categoria.DadosListarCategorias;

public record DadosListarUsuarios(String username, Role role) {

    public DadosListarUsuarios (Usuario usuario) {
        this(usuario.getUsername(), usuario.getRole());
    }
}
