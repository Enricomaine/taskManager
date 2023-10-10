package com.taskManager.domain.lembrete.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizaLembrete(
        @NotNull
        Long idtarefa,
        String descricao,
        @NotNull
        LocalDateTime datahora_aviso
) {
}
