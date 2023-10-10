package com.taskManager.domain.lembrete.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastrarLembrete(
        @NotNull Long idtarefa,
        String descricao,
        @NotNull @Future LocalDateTime datahora_aviso) {
}
