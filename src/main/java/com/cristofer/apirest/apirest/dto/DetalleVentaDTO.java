package com.cristofer.apirest.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {

    private Long id;

    private Long ventaId;

    private Long productoId;

    private int cantidad;

    private double subtotal;

    private double total;

}
