package com.cristofer.apirest.apirest.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.cristofer.apirest.apirest.Entities.Categoria;
import com.cristofer.apirest.apirest.Entities.Producto;
import com.cristofer.apirest.apirest.Repositories.CategoriaRepository;
import com.cristofer.apirest.apirest.Repositories.ProductoRepository;
import com.cristofer.apirest.apirest.dto.ProductoDTO;

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Producto crearProducto(ProductoDTO dto) {
        Producto producto = new Producto();

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCantidad(dto.getCantidad());
        producto.setTipo_pesaje(Producto.TipoPesaje.valueOf(dto.getTipoPesaje()));
        producto.setFecha_vencimiento(LocalDate.parse(dto.getFechaVencimiento()));
        producto.setIva(dto.getIva());

        // Obtener la categoría desde el ID
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        producto.setCategoria_id(categoria);

        return productoRepository.save(producto);
    }

}
