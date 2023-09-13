package com.taskManager.categoria;

public record DadosListarCategorias(Long idCategoria, String descricao) {

    public DadosListarCategorias(Categoria categoria){
        this(categoria.getIdCategoria(), categoria.getDescricao());
    }
}
