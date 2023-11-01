package com.taskManager.controller;

import com.taskManager.domain.tarefa.CadastroTarefa;
import com.taskManager.domain.tarefa.Status;
import com.taskManager.domain.tarefa.dto.DadosCadastrarTarefa;
import com.taskManager.domain.usuario.Roles;
import com.taskManager.domain.usuario.Usuario;
import com.taskManager.infra.security.TokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class TarefaControllerTest {

    @Autowired private MockMvc mvc;
    @Autowired private JacksonTester<DadosCadastrarTarefa> dadosCadastrarTarefaJson;
    @Autowired private TokenService tokenService;
    @MockBean private CadastroTarefa cadastro;

    @Test
    @DisplayName("Retorna 400 quando dados são inválidos")
    @WithMockUser
    void criarTarefaCenario1() throws Exception {
        var response = mvc.perform(post("/tarefa")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Retorna 200 quando dados são válidos")
    @WithMockUser
    void criarTarefaCenario2() throws Exception {
        var dataPrazo = LocalDateTime.now().plusHours(1);
        var usuario = new Usuario(1L, "admin", "$2a$12$A6K1r5J6pTttM1jPECGt3eQGP6p55/eY8lNL.LWMBJ62II7sLGCZO", Roles.admin, null, true );
        var token = "Bearer " + tokenService.gerarToken(usuario);


        var dados = new DadosCadastrarTarefa("teste Título", "teste Descrição", 1L, Status.aberto, dataPrazo);
        doNothing().when(cadastro).cadastrar(any(DadosCadastrarTarefa.class), any(Long.class));

        var response = mvc.perform(post("/tarefa")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastrarTarefaJson.write(
                        dados
                ).getJson())
        ).andReturn().getResponse();

        var jsonEsperado = dadosCadastrarTarefaJson.write(
                dados
        ).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);

    }


}