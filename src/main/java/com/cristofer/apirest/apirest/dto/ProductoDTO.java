package com.cristofer.apirest.apirest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotNull(message = "El precio no puede estar vacío")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Integer precio;

    @NotNull(message = "La cantidad no puede estar vacía")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotBlank(message = "El tipo de pesaje no puede estar vacío")
    private String tipoPesaje;

    @NotBlank(message = "La fecha de vencimiento no puede estar vacía")
    private String fechaVencimiento;

    @NotNull(message = "El iva no puede estar vacío")
    private int iva;

    @NotNull(message = "La categoria no puede estar vacía")
    private Long categoriaId;

}
