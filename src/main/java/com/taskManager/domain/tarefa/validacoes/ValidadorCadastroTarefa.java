package com.taskManager.domain.tarefa.validacoes;

import com.taskManager.domain.tarefa.dto.DadosCadastrarTarefa;

public interface ValidadorCadastroTarefa {

    void validar(DadosCadastrarTarefa dados);
}
