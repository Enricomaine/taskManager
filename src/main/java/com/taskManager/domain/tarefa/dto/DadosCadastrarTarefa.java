package com.taskManager.domain.tarefa.dto;

import com.taskManager.domain.tarefa.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastrarTarefa(

        @NotBlank
        String titulo,
        String descricao,
        @NotBlank
        Long idcategoria,
        @NotNull
        Status status,
        LocalDateTime prazo,
        @NotBlank
        Long idusuario
) {
}
