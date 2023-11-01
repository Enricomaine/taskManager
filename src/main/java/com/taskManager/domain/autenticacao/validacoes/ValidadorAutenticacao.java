package com.taskManager.domain.autenticacao.validacoes;

import com.taskManager.domain.usuario.dto.DadosAutenticacao;

public interface ValidadorAutenticacao {
    void validar(DadosAutenticacao dados);

}
