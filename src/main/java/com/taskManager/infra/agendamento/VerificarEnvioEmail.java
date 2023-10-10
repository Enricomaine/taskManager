package com.taskManager.infra.agendamento;

import com.taskManager.domain.lembrete.Lembrete;
import com.taskManager.domain.lembrete.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class VerificarEnvioEmail {

    @Autowired private LembreteRepository lembreteRepository;

    @Scheduled(fixedRate = 600000)
    public void verificarEmailsParaEnviar() {
        var periodoDeAnalise = LocalDateTime.now().plusMinutes(10);
        List<Lembrete> listaLembretes = lembreteRepository.findAllByDataEntreAgoraEDaquiAPouco(periodoDeAnalise);

        for (Lembrete l : listaLembretes) {
            System.out.println(l.getDescricao());
            System.out.println(l.getDatahora_aviso());
            System.out.println(l.getTarefa());
        }
    }
}
