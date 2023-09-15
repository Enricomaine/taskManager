package com.taskManager.tarefa;

import com.taskManager.categoria.CategoriaRepository;
import com.taskManager.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CadastroTarefa {

    @Autowired private TarefaRepository tarefaRepository;
    @Autowired private CategoriaRepository categoriaRepository;
    @Autowired private UsuarioRepository usuarioRepository;

    public void cadastrar(DadosCadastrarTarefa dados) {
        var categoria = categoriaRepository.getReferenceById(dados.idCategoria().getIdCategoria());
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario().getIdUsuario());
        var dataHoraAtual = LocalDateTime.now();
        var tarefa = new Tarefa(null, categoria, dados.titulo(), dados.descricao(), dados.status(), dados.prazo(), dataHoraAtual, usuario);
        tarefaRepository.save(tarefa);
    }
}
