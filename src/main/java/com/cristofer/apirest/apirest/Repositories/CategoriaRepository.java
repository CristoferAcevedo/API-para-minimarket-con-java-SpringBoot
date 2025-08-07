package com.cristofer.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristofer.apirest.apirest.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}