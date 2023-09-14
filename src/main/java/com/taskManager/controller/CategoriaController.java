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

    @PutMapping
    @Transactional
    public void alterar(@RequestBody DadosAtualizaCategoria dados) {

    }
}
