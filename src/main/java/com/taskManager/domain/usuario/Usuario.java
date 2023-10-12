package com.taskManager.domain.usuario;

import com.taskManager.domain.usuario.dto.DadosCadastrarUsuario;
import com.taskManager.domain.usuario.dto.DadosAtualizaUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idusuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @Column(unique = true)
    private String username;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Roles role;

    private String email;

    private boolean ativo;

    public Usuario(DadosCadastrarUsuario dados, String senhaCodificada) {
        this.username = dados.username();
        this.senha = senhaCodificada;
        this.role = dados.role();
        this.ativo = true;
    }

    public void atualizaDados(DadosAtualizaUsuario dados) {
        this.username = dados.username();
        this.senha = dados.senha();
        this.role = dados.roles();
    }

    public void mudaAtivo() {
        this.ativo = !this.ativo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getAuthority()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
