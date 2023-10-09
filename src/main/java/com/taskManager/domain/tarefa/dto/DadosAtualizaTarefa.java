package com.taskManager.domain.tarefa.dto;

import com.taskManager.domain.tarefa.Status;

import java.time.LocalDateTime;

public record DadosAtualizaTarefa(
        Long idcategoria,
        String titulo,
        String descricao,
        Status status,
        LocalDateTime prazo
        ) {
}
