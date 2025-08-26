package com.cristofer.apirest.apirest.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    @NotBlank(message = "La fecha no puede estar vacía")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe estar en formato yyyy-MM-dd")
    private String fecha;

    @NotNull(message = "El ID del vendedor no puede estar vacío")
    private Long vendedorId;

    @NotNull(message = "Los detalles de la venta no pueden estar vacíos")
    private List<DetalleVentaDTO> detalles;

}
