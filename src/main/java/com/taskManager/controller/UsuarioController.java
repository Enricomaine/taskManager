package com.taskManager.controller;

import com.taskManager.domain.usuario.Usuario;
import com.taskManager.domain.usuario.UsuarioRepository;
import com.taskManager.domain.usuario.dto.DadosAtualizaUsuario;
import com.taskManager.domain.usuario.dto.DadosCadastrarUsuario;
import com.taskManager.domain.usuario.dto.DadosListarUsuarios;
import com.taskManager.domain.usuario.validacoes.ValidadorCadastroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired private UsuarioRepository repository;
    @Autowired private List<ValidadorCadastroUsuario> validadorUsuario;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody DadosCadastrarUsuario dados) {
        validadorUsuario.forEach(v -> v.validar(dados));
        var senhaCodificada = passwordEncoder.encode(dados.senha());


        repository.save(new Usuario(dados, senhaCodificada));

        return ResponseEntity.ok(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarUsuarios>> listar(@PageableDefault Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListarUsuarios::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{idusuario}")
    @Transactional
    public ResponseEntity alterar(@PathVariable Long idusuario, @RequestBody DadosAtualizaUsuario dados) {
        var usuario = repository.getReferenceById(idusuario);

        validadorUsuario.forEach(v -> v.validar(dados));
        usuario.atualizaDados(dados);

        return ResponseEntity.ok(dados);
    }

    @DeleteMapping("/{idusuario}")
    @Transactional
    public ResponseEntity mudaAtivo(@PathVariable Long idusuario) {
        var usuario = repository.getReferenceById(idusuario);
        usuario.mudaAtivo();

        return ResponseEntity.noContent().build();
    }
}
