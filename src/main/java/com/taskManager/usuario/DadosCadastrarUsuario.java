package com.taskManager.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarUsuario(
        @NotBlank
        String username,
        @NotBlank
        String senha,
        @NotBlank
        Role role) {
}
