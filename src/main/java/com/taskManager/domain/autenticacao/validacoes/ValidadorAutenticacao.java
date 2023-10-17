package com.taskManager.domain.autenticacao.validacoes;

import com.taskManager.domain.usuario.dto.DadosAtualizaUsuario;
import com.taskManager.domain.usuario.dto.DadosAutenticacao;
import com.taskManager.domain.usuario.dto.DadosCadastrarUsuario;

public interface ValidadorAutenticacao {
    void validar(DadosAutenticacao dados);

}
