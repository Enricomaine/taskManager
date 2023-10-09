package com.taskManager.domain.categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Page<Categoria> findAllByAtivoTrue(Pageable paginacao);

    boolean existsByDescricao(String descricao);

   @Query("""
            select ativo from categoria where descricao = :descricao""")
    boolean findAtivoByDescricao(String descricao);


   @Query("""
           select ativo from categoria where idcategoria = :idcategoria""")
    boolean findAtivoByIdcategoria(Long idcategoria);
}
