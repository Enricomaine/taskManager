package com.taskManager.domain.categoria;

import com.taskManager.domain.categoria.dto.DadosAtualizaCategoria;
import com.taskManager.domain.categoria.dto.DadosCadastrarCategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categoria")
@Entity(name = "categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idcategoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private Long idcategoria;

    @Column(unique = true)
    private String descricao;

    private boolean ativo;

    public Categoria(DadosCadastrarCategoria dados) {
        this.descricao = dados.descricao();
        this.ativo = true;
    }

    public void atualizaDados(DadosAtualizaCategoria dados) {
        this.descricao = dados.descricao();
    }

    public void mudaAtivo() {
        this.ativo = !this.ativo;
    }
}
