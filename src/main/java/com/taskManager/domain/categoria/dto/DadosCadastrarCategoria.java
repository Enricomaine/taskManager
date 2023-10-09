package com.taskManager.domain.categoria.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarCategoria(
        @NotBlank String descricao) {
}
