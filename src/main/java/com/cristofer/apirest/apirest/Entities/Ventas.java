package com.cristofer.apirest.apirest.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ventas {
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendedor")
    private Usuarios vendedor;

    private Date fechaVenta;
}
