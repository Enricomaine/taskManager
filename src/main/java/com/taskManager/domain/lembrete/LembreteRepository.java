package com.taskManager.domain.lembrete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface LembreteRepository extends JpaRepository<Lembrete, Long> {

    @Query("""
            select
            	l.tarefa.idtarefa,
            	l.descricao,
            	l.datahora_aviso,
            	t.titulo,
            	u.email
            from
            	lembrete l
            	join tarefa t on t.idtarefa = l.tarefa.idtarefa
            	join usuario u on t.usuario.idusuario = u.idusuario
            where
            	datahora_aviso between current_timestamp and :periodoDeAnalise
            """)
    List<Object[]> findAllByDataEntreAgoraEDaquiAPouco(LocalDateTime periodoDeAnalise);
}
