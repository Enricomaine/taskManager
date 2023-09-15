package com.taskManager.controller;

import com.taskManager.categoria.*;
import com.taskManager.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void criar(@RequestBody DadosCadastrarUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public List<DadosListarUsuarios> listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListarUsuarios::new).toList();
    }

    @PutMapping("/{idUsuario}")
    @Transactional
    public void alterar(@PathVariable Long idUsuario, @RequestBody DadosAtualizaUsuario dados) {
        var usuario = repository.getReferenceById(idUsuario);
        usuario.atualizaDados(dados);
    }

    @DeleteMapping("/{idUsuario}")
    @Transactional
    public void mudaAtivo(@PathVariable Long idUsuario) {
        var usuario = repository.getReferenceById(idUsuario);
        usuario.mudaAtivo();
    }
}
