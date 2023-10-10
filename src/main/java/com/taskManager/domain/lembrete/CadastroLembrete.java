package com.taskManager.domain.lembrete;

import com.taskManager.domain.lembrete.dto.DadosCadastrarLembrete;
import com.taskManager.domain.lembrete.validacoes.ValidadorCadastroLembrete;
import com.taskManager.domain.tarefa.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CadastroLembrete {

    @Autowired private TarefaRepository tarefaRepository;
    @Autowired private LembreteRepository lembreteRepository;
    @Autowired private List<ValidadorCadastroLembrete> validador;

    public void cadastrar(DadosCadastrarLembrete dados) {
        var tarefa = tarefaRepository.getReferenceById(dados.idtarefa());
        var dataHoraAtual = LocalDateTime.now();
        var lembrete = new Lembrete(null, tarefa, dados.descricao(), dataHoraAtual, dados.datahora_aviso());
        validador.forEach(v -> v.validar(dados));

        lembreteRepository.save(lembrete);
    }
}
