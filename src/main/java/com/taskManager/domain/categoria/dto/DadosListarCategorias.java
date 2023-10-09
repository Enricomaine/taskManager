package com.taskManager.domain.categoria.dto;

import com.taskManager.domain.categoria.Categoria;

public record DadosListarCategorias(Long idCategoria, String descricao) {

    public DadosListarCategorias(Categoria categoria){
        this(categoria.getIdcategoria(), categoria.getDescricao());
    }
}
