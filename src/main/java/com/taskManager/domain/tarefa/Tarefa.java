package com.taskManager.domain.tarefa;

import com.taskManager.domain.categoria.Categoria;
import com.taskManager.domain.tarefa.dto.DadosAtualizaTarefa;
import com.taskManager.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "tarefa")
@Entity(name = "tarefa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idtarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtarefa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private LocalDateTime prazo;

    private LocalDateTime datacriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public void atualizaDados(DadosAtualizaTarefa dados, Categoria categoria) {
        this.categoria = categoria;
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.prazo = dados.prazo();
        this.status = dados.status();
    }
}
