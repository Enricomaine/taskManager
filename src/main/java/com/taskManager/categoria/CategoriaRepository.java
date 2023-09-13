package com.taskManager.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    String findAllByAtivoTrue(DadosListarCategorias dados);

}
