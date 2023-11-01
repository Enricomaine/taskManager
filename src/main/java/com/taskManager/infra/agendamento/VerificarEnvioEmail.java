package com.taskManager.infra.agendamento;

import com.taskManager.domain.lembrete.LembreteRepository;
import com.taskManager.infra.mail.EnvioEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class VerificarEnvioEmail {

    @Autowired private LembreteRepository lembreteRepository;
    @Autowired private EnvioEmail envioEmail;

    @Scheduled(fixedRate = 300000)
    public void verificarEmailsParaEnviar() {
        var periodoDeAnalise = LocalDateTime.now().plusMinutes(5);
        List<Object[]> resultList = lembreteRepository.findAllByDataEntreAgoraEDaquiAPouco(periodoDeAnalise);

        if(!resultList.isEmpty()) {
            for (Object[] objects : resultList) {
                var corpo = objects[1];
                var assunto = objects[3];
                var email = objects[4];

                envioEmail.enviarEmail((String) corpo, (String) assunto, (String) email);
            }
        }
    }
}
