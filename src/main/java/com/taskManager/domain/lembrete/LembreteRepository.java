package com.taskManager.domain.lembrete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface LembreteRepository extends JpaRepository<Lembrete, Long> {

    @Query("""
            select
                idtarefa,
                descricao,
                datahora_aviso
            from lembrete
            where
                datahora_aviso between current_datetime and :periodoDeAnalise""")
    List<Lembrete> findAllByDataEntreAgoraEDaquiAPouco(LocalDateTime periodoDeAnalise);
}
