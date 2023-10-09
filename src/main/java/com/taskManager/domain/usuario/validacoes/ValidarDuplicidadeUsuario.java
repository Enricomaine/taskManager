package com.taskManager.domain.usuario.validacoes;

import com.taskManager.domain.categoria.CategoriaRepository;
import com.taskManager.domain.categoria.dto.DadosAtualizaCategoria;
import com.taskManager.domain.categoria.dto.DadosCadastrarCategoria;
import com.taskManager.domain.usuario.UsuarioRepository;
import com.taskManager.domain.usuario.dto.DadosAtualizaUsuario;
import com.taskManager.domain.usuario.dto.DadosCadastrarUsuario;
import com.taskManager.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarDuplicidadeUsuario implements ValidadorCadastroUsuario {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validar(DadosCadastrarUsuario dados) {
        if (repository.existsByUsername(dados.username())) {
            if(!repository.findAtivoByUsername(dados.username())) {
                throw new ValidacaoException("Usuário: " + dados.username() + " já cadastrado e está inativo");
            } else {
                throw new ValidacaoException("Usuário: "+dados.username()+" já cadastrado!");

            }
        }
    }

    @Override
    public void validar(DadosAtualizaUsuario dados) {
        if(repository.existsByUsername(dados.username())) {
            if(!repository.findAtivoByUsername(dados.username())) {
                throw new ValidacaoException("Usuário: " + dados.username() + " já cadastrado e está inativo");
            } else {
                throw new ValidacaoException("Usuário: " + dados.username() + " já cadastrado!");
            }
        }
    }
}
