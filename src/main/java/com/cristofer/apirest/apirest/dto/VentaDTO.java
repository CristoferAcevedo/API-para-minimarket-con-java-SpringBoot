package com.cristofer.apirest.apirest.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    private Long id;

    private Date fecha;

    private Long clienteId;
}
