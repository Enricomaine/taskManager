package com.taskManager.controller;

import com.taskManager.categoria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public void criar(@RequestBody DadosCadastrarCategoria dados) {
        repository.save(new Categoria(dados));
    }

    @GetMapping
    public List<DadosListarCategorias> listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListarCategorias::new).toList();
    }

    @PutMapping("/{idCategoria}")
    @Transactional
    public void alterar(@PathVariable Long idCategoria, @RequestBody DadosAtualizaCategoria dados) {
        var categoria = repository.getReferenceById(idCategoria);
        categoria.atualizaDados(dados);
    }

    @DeleteMapping("/{idCategoria}")
    @Transactional
    public void mudaAtivo(@PathVariable Long idCategoria) {
        var categoria = repository.getReferenceById(idCategoria);
        categoria.mudaAtivo();
    }
}
