package com.taskManager.tarefa;

import com.taskManager.categoria.Categoria;
import com.taskManager.usuario.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastrarTarefa(

        @NotBlank
        String titulo,
        String descricao,
        @NotBlank
        Categoria idCategoria,
        @NotNull
        Status status,
        LocalDateTime prazo,
        @NotBlank
        Usuario idUsuario
) {
}
