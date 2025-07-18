package com.cristofer.apirest.apirest.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ROl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String nombre;

    // 🔗 RELACIÓN UNO A MUCHOS
    @OneToMany(mappedBy = "rol")
    private List<Usuarios> usuarios;
}
