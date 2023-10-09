package com.taskManager.domain.tarefa.validacoes;

import com.taskManager.domain.categoria.CategoriaRepository;
import com.taskManager.domain.tarefa.dto.DadosCadastrarTarefa;
import com.taskManager.domain.usuario.UsuarioRepository;
import com.taskManager.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaUsuarioInativo implements ValidadorCadastroTarefa {

    @Autowired private UsuarioRepository usuarioRepository;


    @Override
    public void validar(DadosCadastrarTarefa dados) {

        var usuarioAtivo = usuarioRepository.findAtivoByIdusuario(dados.idusuario());

        if(!usuarioAtivo){
            throw new ValidacaoException("Usuario Inativo!");
        }
    }
}
