package com.taskManager.controller;

import com.taskManager.domain.categoria.Categoria;
import com.taskManager.domain.categoria.CategoriaRepository;
import com.taskManager.domain.categoria.dto.DadosAtualizaCategoria;
import com.taskManager.domain.categoria.dto.DadosCadastrarCategoria;
import com.taskManager.domain.categoria.dto.DadosListarCategorias;
import com.taskManager.domain.categoria.validacoes.ValidadorCadastroCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private List<ValidadorCadastroCategoria> validaCadastro;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody DadosCadastrarCategoria dados) {
        validaCadastro.forEach(v -> v.validar(dados));
        repository.save(new Categoria(dados));

        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarCategorias>> listar(@PageableDefault Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListarCategorias::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{idcategoria}")
    @Transactional
    public ResponseEntity alterar(@PathVariable Long idcategoria, @RequestBody DadosAtualizaCategoria dados) {
        var categoria = repository.getReferenceById(idcategoria);
        validaCadastro.forEach(v -> v.validar(dados));
        categoria.atualizaDados(dados);

        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{idcategoria}")
    @Transactional
    public ResponseEntity mudaAtivo(@PathVariable Long idcategoria) {
        var categoria = repository.getReferenceById(idcategoria);
        categoria.mudaAtivo();

        return ResponseEntity.noContent().build();
    }
}
