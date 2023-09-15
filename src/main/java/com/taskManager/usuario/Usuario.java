package com.taskManager.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;

    @Column(unique = true)
    private String username;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean ativo;

    public Usuario(DadosCadastrarUsuario dados) {
        this.username = dados.username();
        this.senha = dados.senha();
        this.role = dados.role();
        this.ativo = true;
    }

    public void atualizaDados(DadosAtualizaUsuario dados) {
        this.username = dados.username();
        this.senha = dados.senha();
        this.role = dados.role();
    }

    public void mudaAtivo() {
        this.ativo = !this.ativo;
    }
}
