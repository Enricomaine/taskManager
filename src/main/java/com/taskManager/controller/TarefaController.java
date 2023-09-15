package com.taskManager.controller;

import com.taskManager.categoria.*;
import com.taskManager.tarefa.CadastroTarefa;
import com.taskManager.tarefa.DadosCadastrarTarefa;
import com.taskManager.tarefa.Tarefa;
import com.taskManager.tarefa.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired
    private CadastroTarefa cadastro;


    @PostMapping
    @Transactional
    public void criar(@RequestBody DadosCadastrarTarefa dados) {
        cadastro.cadastrar(dados);
    }
//
//    @GetMapping
//    public List<DadosListarCategorias> listar() {
//        return repository.findAllByAtivoTrue().stream().map(DadosListarCategorias::new).toList();
//    }
//
//    @PutMapping("/{idCategoria}")
//    @Transactional
//    public void alterar(@PathVariable Long idCategoria, @RequestBody DadosAtualizaCategoria dados) {
//        var categoria = repository.getReferenceById(idCategoria);
//        categoria.atualizaDados(dados);
//    }
//
//    @DeleteMapping("/{idCategoria}")
//    @Transactional
//    public void mudaAtivo(@PathVariable Long idCategoria) {
//        var categoria = repository.getReferenceById(idCategoria);
//        categoria.mudaAtivo();
//    }
}
