package com.taskManager.domain.lembrete.validacoes;

import com.taskManager.domain.lembrete.dto.DadosCadastrarLembrete;
import com.taskManager.domain.tarefa.TarefaRepository;
import com.taskManager.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaTarefaAberta implements ValidadorCadastroLembrete {

    @Autowired private TarefaRepository tarefaRepository;

    @Override
    public void validar(DadosCadastrarLembrete dados) {

        var StatusTarefa = tarefaRepository.findTarefaAbertaById(dados.idtarefa());

        if(StatusTarefa != 1){
            throw new ValidacaoException("Tarefa não encontra-se em aberto!");
        }
    }
}
