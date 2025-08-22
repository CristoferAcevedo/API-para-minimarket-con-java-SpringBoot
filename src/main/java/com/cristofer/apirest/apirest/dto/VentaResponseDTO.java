package com.cristofer.apirest.apirest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponseDTO {
    private Long id;
    private String fecha;
    private Long clienteId;
    private List<DetalleResponseDTO> detalles;
}
