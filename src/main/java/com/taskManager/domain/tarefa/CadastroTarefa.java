package com.taskManager.domain.tarefa;

import com.taskManager.domain.categoria.CategoriaRepository;
import com.taskManager.domain.tarefa.dto.DadosCadastrarTarefa;
import com.taskManager.domain.tarefa.validacoes.ValidadorCadastroTarefa;
import com.taskManager.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CadastroTarefa {

    @Autowired private TarefaRepository tarefaRepository;
    @Autowired private CategoriaRepository categoriaRepository;
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private List<ValidadorCadastroTarefa> validador;

    public void cadastrar(DadosCadastrarTarefa dados, Long idusuario) {
        var categoria = categoriaRepository.getReferenceById(dados.idcategoria());
        var usuario = usuarioRepository.getReferenceById(idusuario);
        var dataHoraAtual = LocalDateTime.now();
        var tarefa = new Tarefa(null, categoria, dados.titulo(), dados.descricao(), dados.status(), dados.prazo(), dataHoraAtual, usuario);
        validador.forEach(v -> v.validar(dados));

        tarefaRepository.save(tarefa);
    }
}
