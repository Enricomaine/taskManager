package com.taskManager.tarefa;

import com.taskManager.categoria.Categoria;
import com.taskManager.usuario.Usuario;
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
@EqualsAndHashCode(of = "idTarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria idCategoria;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private LocalDateTime prazo;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

}
