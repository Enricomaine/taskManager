package com.taskManager.domain.usuario.dto;

import com.taskManager.domain.usuario.Roles;

public record DadosAtualizaUsuario(String username, String senha, Roles roles) {
}
