package com.cristofer.apirest.apirest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristofer.apirest.apirest.Entities.DetalleVenta;
import com.cristofer.apirest.apirest.Entities.Producto;
import com.cristofer.apirest.apirest.Entities.Usuarios;
import com.cristofer.apirest.apirest.Entities.Ventas;
import com.cristofer.apirest.apirest.Repositories.DetalleVentaRepository;
import com.cristofer.apirest.apirest.Repositories.ProductoRepository;
import com.cristofer.apirest.apirest.Repositories.UsuariosRepository;
import com.cristofer.apirest.apirest.Repositories.VentasRepository;
import com.cristofer.apirest.apirest.dto.DetalleResponseDTO;
import com.cristofer.apirest.apirest.dto.DetalleVentaDTO;
import com.cristofer.apirest.apirest.dto.VentaDTO;
import com.cristofer.apirest.apirest.dto.VentaResponseDTO;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // obtener todas las ventas
    public List<Ventas> getVentas() {
        return ventasRepository.findAll();
    }

    // crear una venta
    public VentaResponseDTO crearVenta(VentaDTO ventaDTO) {

        // Buscar cliente
        Usuarios cliente = usuariosRepository.findById(ventaDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + ventaDTO.getClienteId()));

        // Crear la venta
        Ventas venta = new Ventas();
        venta.setVendedor(cliente);
        venta.setFechaVenta(LocalDate.parse(ventaDTO.getFecha()));

        // Guardar primero la venta
        Ventas ventaRealizada = ventasRepository.save(venta);

        List<DetalleResponseDTO> detallesResponse = new ArrayList<>();

        // Recorrer cada detalle de la venta
        for (DetalleVentaDTO detalleDTO : ventaDTO.getDetalles()) {
            Producto producto = productoRepository.findById(detalleDTO.getProductoId())
                    .orElseThrow(
                            () -> new RuntimeException("Producto no encontrado con id: " + detalleDTO.getProductoId()));

            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setVentaId(ventaRealizada);
            detalleVenta.setProductoId(producto);
            detalleVenta.setCantidad(detalleDTO.getCantidad());

            detalleVenta.setSubtotal(detalleDTO.getSubtotal());
            detalleVenta.setTotal(detalleDTO.getTotal());

            detalleVentaRepository.save(detalleVenta);

            // Llenar el response del detalle
            DetalleResponseDTO detalleResponse = new DetalleResponseDTO();
            detalleResponse.setProductoId(producto.getId());
            detalleResponse.setNombreProducto(producto.getNombre());
            detalleResponse.setCantidad(detalleVenta.getCantidad());
            detalleResponse.setSubtotal(detalleVenta.getSubtotal());
            detalleResponse.setTotal(detalleVenta.getTotal());

            detallesResponse.add(detalleResponse);
        }

        // Construir el response de la venta
        VentaResponseDTO ventaResponse = new VentaResponseDTO();
        ventaResponse.setId(ventaRealizada.getId());
        ventaResponse.setFecha(ventaRealizada.getFechaVenta().toString());
        ventaResponse.setClienteId(cliente.getId());
        ventaResponse.setDetalles(detallesResponse);

        return ventaResponse;
    }

}
