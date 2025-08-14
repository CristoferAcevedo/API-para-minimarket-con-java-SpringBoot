package com.cristofer.apirest.apirest.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristofer.apirest.apirest.Entities.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByCorreo(String correo);
}
