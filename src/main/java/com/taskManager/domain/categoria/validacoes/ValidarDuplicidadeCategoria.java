package com.taskManager.domain.categoria.validacoes;

import com.taskManager.domain.categoria.CategoriaRepository;
import com.taskManager.domain.categoria.dto.DadosAtualizaCategoria;
import com.taskManager.domain.categoria.dto.DadosCadastrarCategoria;
import com.taskManager.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarDuplicidadeCategoria implements ValidadorCadastroCategoria {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public void validar(DadosCadastrarCategoria dados) {
        if (repository.existsByDescricao(dados.descricao())) {
            if(!repository.findAtivoByDescricao(dados.descricao())) {
                throw new ValidacaoException("Categoria: "+dados.descricao()+" já cadastrada e está inativa");
            } else {
                throw new ValidacaoException("Categoria: " + dados.descricao() + " já cadastrada!");
            }
        }

    }

    @Override
    public void validar(DadosAtualizaCategoria dados) {
        if(repository.existsByDescricao(dados.descricao())) {
            if(!repository.findAtivoByDescricao(dados.descricao())) {
                throw new ValidacaoException("Categoria: " + dados.descricao() + " já cadastrada e está inativa");
            } else {
                throw new ValidacaoException("Categoria: " + dados.descricao() + " já cadastrada!");
            }
        }
    }
}
