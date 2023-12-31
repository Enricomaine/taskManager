package com.taskManager.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.taskManager.domain.categoria.CategoriaRepository;
import com.taskManager.domain.tarefa.CadastroTarefa;
import com.taskManager.domain.tarefa.TarefaRepository;
import com.taskManager.domain.tarefa.dto.DadosAtualizaTarefa;
import com.taskManager.domain.tarefa.dto.DadosCadastrarTarefa;
import com.taskManager.domain.tarefa.dto.DadosListarTarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired private CadastroTarefa cadastro;
    @Autowired private TarefaRepository tarefaRepository;
    @Autowired private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody DadosCadastrarTarefa dados, @RequestHeader("Authorization") String token) {
        DecodedJWT decodedJWT = JWT.decode(token.replace("Bearer ", ""));
        Long idusuario = decodedJWT.getClaim("idusuario").asLong();
        cadastro.cadastrar(dados, idusuario);

        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarTarefas>> listar(@PageableDefault Pageable paginacao) {
        var page = tarefaRepository.findAll(paginacao).map(DadosListarTarefas::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{idtarefa}")
    @Transactional
    public ResponseEntity alterar(@PathVariable Long idtarefa, @RequestBody DadosAtualizaTarefa dados) {
        var categoria = categoriaRepository.getReferenceById(dados.idcategoria());
        var tarefa = tarefaRepository.getReferenceById(idtarefa);
        tarefa.atualizaDados(dados, categoria);

        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{idtarefa}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long idtarefa) {
        tarefaRepository.deleteById(idtarefa);
        return ResponseEntity.noContent().build();
    }

}
