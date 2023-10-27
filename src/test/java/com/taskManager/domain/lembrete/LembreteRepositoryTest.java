package com.taskManager.domain.lembrete;

import com.taskManager.domain.categoria.Categoria;
import com.taskManager.domain.tarefa.Status;
import com.taskManager.domain.tarefa.Tarefa;
import com.taskManager.domain.usuario.Roles;
import com.taskManager.domain.usuario.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class LembreteRepositoryTest {

    @Autowired private LembreteRepository lembreteRepository;
    @Autowired private TestEntityManager em;

    @Test
    @DisplayName("Retorna null se não encontrar nenhum lembrete no período")
    void findAllByDataEntreAgoraEDaquiAPoucoCenario1() {
        var periodoDeAnalise = LocalDateTime.now().plusMinutes(5);
        var lembretesEncontrados = lembreteRepository.findAllByDataEntreAgoraEDaquiAPouco(periodoDeAnalise);
        assertThat(lembretesEncontrados).isEmpty();
    }

    @Test
    @DisplayName("Retorna uma lista de lembretes no período")
    void findAllByDataEntreAgoraEDaquiAPoucoCenario2() {
        var periodoDeAnalise = LocalDateTime.now().plusMinutes(5);
        var foraDoPeriodoDeAnalise = LocalDateTime.now().plusMinutes(6);
        var prazoTarefaTeste = LocalDateTime.now().plusHours(5);
        var dataHoraAtual = LocalDateTime.now();

        var usuario = cadastrarUsuario();
        var categoria = cadastrarCategoria();
        var tarefa = cadastrarTarefa(categoria, prazoTarefaTeste, dataHoraAtual, usuario);

        cadastrarLembrete(tarefa, dataHoraAtual, periodoDeAnalise);
        cadastrarLembrete(tarefa, dataHoraAtual, periodoDeAnalise);
        cadastrarLembrete(tarefa, dataHoraAtual, foraDoPeriodoDeAnalise);
        var lembretesEncontrados = lembreteRepository.findAllByDataEntreAgoraEDaquiAPouco(periodoDeAnalise);

        assertThat(lembretesEncontrados).hasSize(2);
    }


    private void cadastrarLembrete(Tarefa tarefa, LocalDateTime datahora_criacao, LocalDateTime datahora_aviso) {
        em.persist(new Lembrete(null, tarefa, "descricaoTeste", datahora_criacao, datahora_aviso));
    }
    private Tarefa cadastrarTarefa(Categoria categoria, LocalDateTime prazo, LocalDateTime datacriacao, Usuario usuario) {
        var tarefa = new Tarefa(null, categoria, "titulo", "descricao", Status.aberto, prazo, datacriacao, usuario);
        em.persist(tarefa);
        return tarefa;
    }
    private Categoria cadastrarCategoria() {
        var categoria = new Categoria(null, "testeCategoria", true);
        em.persist(categoria);
        return categoria;
    }
    private Usuario cadastrarUsuario() {
        var usuario = new Usuario(null, "usernameTeste", "senhaCodificada", Roles.admin, "email@teste.com", true);
        em.persist(usuario);
        return usuario;
    }
}