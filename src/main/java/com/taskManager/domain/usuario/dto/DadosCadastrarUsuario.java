package com.taskManager.domain.usuario.dto;

import com.taskManager.domain.usuario.Roles;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarUsuario(
        @NotBlank
        String username,
        @NotBlank
        String senha,
        @NotBlank
        Roles role) {
}
