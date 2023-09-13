package com.taskManager.controller;

import com.taskManager.categoria.Categoria;
import com.taskManager.categoria.CategoriaRepository;
import com.taskManager.categoria.DadosCadastrarCategoria;
import com.taskManager.categoria.DadosListarCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public void listar(DadosListarCategorias dados) {
        System.out.println(repository.findAllByAtivoTrue(dados));
    }
}
