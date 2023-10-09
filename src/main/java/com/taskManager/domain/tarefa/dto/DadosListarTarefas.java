package com.taskManager.domain.tarefa.dto;

import com.taskManager.domain.tarefa.Tarefa;

import java.time.LocalDateTime;

public record DadosListarTarefas(
        Long idtarefa,
        String categoria,
        String titulo,
        String descricao,
        String status,
        LocalDateTime prazo,
        LocalDateTime datacriacao,
        String usuario) {

    public DadosListarTarefas(Tarefa tarefa) {
        this(tarefa.getIdtarefa(),
                tarefa.getCategoria().getDescricao(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                String.valueOf(tarefa.getStatus()),
                tarefa.getPrazo(),
                tarefa.getDatacriacao(),
                tarefa.getUsuario().getUsername());
    }
}
