package com.cristofer.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristofer.apirest.apirest.Entities.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long> {

}
