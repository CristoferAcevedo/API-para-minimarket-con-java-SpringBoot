package com.cristofer.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristofer.apirest.apirest.Entities.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
