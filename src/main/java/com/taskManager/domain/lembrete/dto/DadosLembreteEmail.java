package com.taskManager.domain.lembrete.dto;

import java.time.LocalDateTime;

public record DadosLembreteEmail(
    String descricao,
    LocalDateTime datahora_aviso,
    String titulo,
    String username,
    String email
) {
}
