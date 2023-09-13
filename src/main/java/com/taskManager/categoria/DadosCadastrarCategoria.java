package com.taskManager.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarCategoria(
        @NotBlank String descricao) {
}
