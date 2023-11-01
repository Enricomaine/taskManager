package com.taskManager.domain.usuario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);

    boolean existsByUsername(String descricao);

    @Query("""
            select distinct ativo from usuario where username = :username""")
    boolean findAtivoByUsername(String username);

    @Query("""
            select ativo from usuario where idusuario = :idusuario""")
    boolean findAtivoByIdusuario(Long idusuario);

    UserDetails findByUsername(String username);
}
