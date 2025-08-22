package com.cristofer.apirest.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleResponseDTO {
    private Long productoId;
    private String nombreProducto;
    private int cantidad;
    private double subtotal;
    private double total;
}
