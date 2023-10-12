package com.taskManager.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:mail.properties")
public class EnvioEmail {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    Environment env;
    @Value("${mail.smtp.host}") private String host;

    public void enviarEmail(String corpo, String assunto, String email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(host);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(assunto);
        simpleMailMessage.setText(corpo);

        javaMailSender.send(simpleMailMessage);
    }
}
