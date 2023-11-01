package com.taskManager.domain.autenticacao.validacoes;

import com.taskManager.domain.usuario.UsuarioRepository;
import com.taskManager.domain.usuario.dto.DadosAutenticacao;
import com.taskManager.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaUsuarioInativo implements ValidadorAutenticacao{

    @Autowired private UsuarioRepository usuarioRepository;

    public void validar(DadosAutenticacao dados) {

        var usuarioAtivo = usuarioRepository.findAtivoByUsername(dados.username());

        if(!usuarioAtivo){
            throw new ValidacaoException("Usuario Inativo!");
        }
    }
}
