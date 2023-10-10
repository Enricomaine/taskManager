package com.taskManager.domain.lembrete.dto;

import com.taskManager.domain.lembrete.Lembrete;

import java.time.LocalDateTime;

public record DadoslistarLembretes(
        Long idlembrete,
        Long idtarefa,
        String descricao,
        LocalDateTime datahora_criacao,
        LocalDateTime datahora_aviso
) {
    public DadoslistarLembretes(Lembrete lembrete) {
        this(lembrete.getIdlembrete(),
                lembrete.getTarefa().getIdtarefa(),
                lembrete.getDescricao(),
                lembrete.getDatahora_criacao(),
                lembrete.getDatahora_aviso());
    }
}
