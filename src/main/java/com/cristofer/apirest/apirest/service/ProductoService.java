package com.cristofer.apirest.apirest.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristofer.apirest.apirest.Entities.Categoria;
import com.cristofer.apirest.apirest.Entities.Producto;
import com.cristofer.apirest.apirest.Repositories.CategoriaRepository;
import com.cristofer.apirest.apirest.Repositories.ProductoRepository;
import com.cristofer.apirest.apirest.dto.ProductoDTO;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    // obtener producto por id
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    // crear un producto
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

    // actualizar un producto
    public Producto actualizarProducto(Long id, ProductoDTO producto) {
        Producto productoExistente = obtenerProductoPorId(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setCantidad(producto.getCantidad());
        productoExistente.setTipo_pesaje(Producto.TipoPesaje.valueOf(producto.getTipoPesaje()));
        productoExistente.setFecha_vencimiento(LocalDate.parse(producto.getFechaVencimiento()));
        productoExistente.setIva(producto.getIva());

        Categoria categoria = categoriaRepository.findById(producto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        productoExistente.setCategoria_id(categoria);

        return productoRepository.save(productoExistente);
    }

    // eliminar un producto
    public Boolean eliminarProducto(Long id) {
        Producto producto = obtenerProductoPorId(id);
        if (producto != null) {
            productoRepository.delete(producto);
            return true;
        }
        return false;
    }

}
