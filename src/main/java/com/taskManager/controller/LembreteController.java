package com.taskManager.controller;

import com.taskManager.domain.lembrete.CadastroLembrete;
import com.taskManager.domain.lembrete.dto.DadosAtualizaLembrete;
import com.taskManager.domain.lembrete.dto.DadosCadastrarLembrete;
import com.taskManager.domain.lembrete.LembreteRepository;
import com.taskManager.domain.lembrete.dto.DadoslistarLembretes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefa/lembrete")
public class LembreteController {

    @Autowired private CadastroLembrete cadastro;
    @Autowired private LembreteRepository lembreteRepository;


    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCadastrarLembrete dados) {
        cadastro.cadastrar(dados);

        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadoslistarLembretes>> listar(@PageableDefault Pageable paginacao) {
        var page = lembreteRepository.findAll(paginacao).map(DadoslistarLembretes::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{idlembrete}")
    @Transactional
    public ResponseEntity alterar(@PathVariable Long idlembrete, @RequestBody DadosAtualizaLembrete dados) {
        var lembrete = lembreteRepository.getReferenceById(idlembrete);
        lembrete.atualizaDados(dados);

        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{idlembrete}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long idlembrete) {
        lembreteRepository.deleteById(idlembrete);
        return ResponseEntity.noContent().build();
    }

}
