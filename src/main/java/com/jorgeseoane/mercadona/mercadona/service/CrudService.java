package com.jorgeseoane.mercadona.mercadona.service;

import com.jorgeseoane.mercadona.mercadona.model.Producto;
import com.jorgeseoane.mercadona.mercadona.repository.DestinoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProductoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProveedorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudService {
    private ProductoRepository productoRepository;
    private ProveedorRepository proveedorRepository;
    private DestinoRepository destinoRepository;

    public CrudService(ProductoRepository productoRepository, ProveedorRepository proveedorRepository, DestinoRepository destinoRepository) {
        this.productoRepository = productoRepository;
        this.proveedorRepository = proveedorRepository;
        this.destinoRepository = destinoRepository;
    }


    @Transactional
    public Producto createOrUpdate(Producto producto){
        if (producto.getId_producto() != null) {
            Producto existente = productoRepository.findById(producto.getId_producto()).orElse(null);

            if (existente != null) {
                existente.setEan(producto.getEan());
                existente.setNombre(producto.getNombre());
                existente.setDescripcion(producto.getDescripcion());
                existente.setId_proveedor(producto.getId_proveedor());
                existente.setId_destino(producto.getId_destino());

                return productoRepository.save(existente);
            }
        }

        return productoRepository.save(producto);
    }

    public List<Producto> findAll() {
        List<Producto> tasksList = productoRepository.findAll();
        return tasksList;
    }

    public Optional<Producto> findById(long id) {
        Optional<Producto> task = productoRepository.findById(id);
        return task;
    }

    @Transactional
    public boolean deleteProducto(Long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("No se pudo encontrar el producto con ID: " + id);
        }
    }


}
