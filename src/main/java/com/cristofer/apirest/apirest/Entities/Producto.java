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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TipoPesaje getTipo_pesaje() {
        return tipo_pesaje;
    }

    public void setTipo_pesaje(TipoPesaje tipo_pesaje) {
        this.tipo_pesaje = tipo_pesaje;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Categoria getCategoria_id() {
        return categoria;
    }

    public void setCategoria_id(Categoria categoria) {
        this.categoria = categoria;
    }

    // getters and setters

}
