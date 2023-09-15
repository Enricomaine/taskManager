package com.taskManager.usuario;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Collection<Usuario> findAllByAtivoTrue();
}
