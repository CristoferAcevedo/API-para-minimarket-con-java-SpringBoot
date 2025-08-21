package com.cristofer.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristofer.apirest.apirest.Entities.Ventas;
import com.cristofer.apirest.apirest.dto.VentaDTO;
import com.cristofer.apirest.apirest.service.VentasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/ventas")
@Tag(name = "Ventas", description = "Operaciones relacionadas con las ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @Operation(summary = "obtener todas las ventas")
    @GetMapping
    public ResponseEntity<List<Ventas>> getVentas() {
        List<Ventas> ventas = ventasService.getVentas();
        return ResponseEntity.ok(ventas);
    }

    @Operation(summary = "crear una nueva venta")
    @PostMapping
    public ResponseEntity<Ventas> crearVenta(@RequestBody VentaDTO ventaDTO) {
        System.out.println("VentaDTO recibida: " + ventaDTO.getFecha() + ", Cliente ID: " + ventaDTO.getClienteId()
                + ", Detalles: " + ventaDTO.getDetalles());
        Ventas ventaCreada = ventasService.crearVenta(ventaDTO);
        if (ventaCreada == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ventaCreada);
    }

}
