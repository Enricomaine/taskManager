package com.taskManager.domain.categoria.validacoes;

import com.taskManager.domain.categoria.dto.DadosAtualizaCategoria;
import com.taskManager.domain.categoria.dto.DadosCadastrarCategoria;

public interface ValidadorCadastroCategoria {
    void validar(DadosCadastrarCategoria dados);

    void validar(DadosAtualizaCategoria dados);
}
