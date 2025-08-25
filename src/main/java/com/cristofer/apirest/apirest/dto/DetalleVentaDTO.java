package com.cristofer.apirest.apirest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {

    @NotNull(message = "El ID del producto no puede estar vacío")
    private Long productoId;

    @NotNull(message = "La cantidad no puede estar vacía")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotNull(message = "El subtotal no puede estar vacío")
    @Min(value = 1, message = "El subtotal debe ser mayor a 0")
    private Integer subtotal;

    @NotNull(message = "La total no puede estar vacío")
    @Min(value = 1, message = "El total debe ser mayor a 0")
    private Integer total;
}
