package com.cristofer.apirest.apirest.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private Double precio;

    private int cantidad;

    @Enumerated(EnumType.STRING)
    private TipoPesaje tipo_pesaje;

    private LocalDate fecha_vencimiento;

    private Double iva;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public enum TipoPesaje {
        UNIDAD,
        GRAMO
    }

}
