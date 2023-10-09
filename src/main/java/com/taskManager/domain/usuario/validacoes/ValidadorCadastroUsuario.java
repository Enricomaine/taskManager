package com.taskManager.domain.usuario.validacoes;

import com.taskManager.domain.usuario.dto.DadosAtualizaUsuario;
import com.taskManager.domain.usuario.dto.DadosCadastrarUsuario;

public interface ValidadorCadastroUsuario {
    void validar(DadosCadastrarUsuario dados);

    void validar(DadosAtualizaUsuario dados);
}
