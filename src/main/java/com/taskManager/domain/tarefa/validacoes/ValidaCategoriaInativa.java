package com.taskManager.domain.tarefa.validacoes;

import com.taskManager.domain.categoria.CategoriaRepository;
import com.taskManager.domain.tarefa.dto.DadosCadastrarTarefa;
import com.taskManager.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaCategoriaInativa implements ValidadorCadastroTarefa {

    @Autowired private CategoriaRepository categoriaRepository;


    @Override
    public void validar(DadosCadastrarTarefa dados) {

        var categoriaAtiva = categoriaRepository.findAtivoByIdcategoria(dados.idcategoria());

        if(!categoriaAtiva){
            throw new ValidacaoException("Categoria Inativa!");
        }
    }
}
