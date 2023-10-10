package com.taskManager.domain.tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("""
            select status from tarefa where idtarefa = :idtarefa""")
    int findTarefaAbertaById(Long idtarefa);
}
