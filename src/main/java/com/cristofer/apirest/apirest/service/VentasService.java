package com.cristofer.apirest.apirest.service;

import java.time.LocalDate;
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
import com.cristofer.apirest.apirest.dto.DetalleVentaDTO;
import com.cristofer.apirest.apirest.dto.VentaDTO;

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
    public Ventas crearVenta(VentaDTO ventaDTO) {

        System.out.println(ventaDTO);

        // Buscar cliente
        Usuarios cliente = usuariosRepository.findById(ventaDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + ventaDTO.getClienteId()));

        // Crear la venta
        Ventas venta = new Ventas();
        venta.setVendedor(cliente);
        venta.setFechaVenta(LocalDate.parse(ventaDTO.getFecha()));

        // Guardar primero la venta
        Ventas ventaRealizada = ventasRepository.save(venta);

        // Recorrer cada detalle de la venta
        for (DetalleVentaDTO detalleDTO : ventaDTO.getDetalles()) {
            Producto producto = productoRepository.findById(detalleDTO.getProductoId())
                    .orElseThrow(
                            () -> new RuntimeException("Producto no encontrado con id: " + detalleDTO.getProductoId()));

            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setVentaId(ventaRealizada);
            detalleVenta.setProductoId(producto);
            detalleVenta.setCantidad(detalleDTO.getCantidad());

            double subtotal = detalleDTO.getCantidad() * producto.getPrecio();
            double total = subtotal * (1 + producto.getIva() / 100);

            detalleVenta.setSubtotal(subtotal);
            detalleVenta.setTotal(total);

            detalleVentaRepository.save(detalleVenta);
        }

        ventasRepository.save(ventaRealizada);

        return ventaRealizada;
    }

}
