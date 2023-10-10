package com.taskManager.domain.lembrete;

import com.taskManager.domain.lembrete.dto.DadosAtualizaLembrete;
import com.taskManager.domain.tarefa.Tarefa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "lembrete")
@Table(name = "lembrete")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlembrete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtarefa")
    @NotNull
    private Tarefa tarefa;
    private String descricao;

    @NotNull
    private LocalDateTime datahora_criacao;
    @NotNull
    private LocalDateTime datahora_aviso;

    public void atualizaDados(DadosAtualizaLembrete dados, Tarefa tarefa) {
        this.tarefa = getTarefa();
        this.datahora_aviso = dados.datahora_aviso();
        this.descricao = dados.descricao();
    }
}
