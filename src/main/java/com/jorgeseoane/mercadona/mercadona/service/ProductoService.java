package com.jorgeseoane.mercadona.mercadona.service;

import com.jorgeseoane.mercadona.mercadona.model.Destino;
import com.jorgeseoane.mercadona.mercadona.model.ProductDetailsDTO;
import com.jorgeseoane.mercadona.mercadona.model.Producto;
import com.jorgeseoane.mercadona.mercadona.model.Proveedor;
import com.jorgeseoane.mercadona.mercadona.repository.DestinoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProductoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;
    private final DestinoRepository destinoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, ProveedorRepository proveedorRepository, DestinoRepository destinoRepository) {
        this.productoRepository = productoRepository;
        this.proveedorRepository = proveedorRepository;
        this.destinoRepository = destinoRepository;
    }

    @Cacheable("myCache")
    public ProductDetailsDTO getProductoDetails(String ean) throws Exception {
        if (ean.length() != 13 || !ean.matches("\\d+")) {
            throw new Exception("EAN inválido");
        }

        String supplierCode = ean.substring(0, 7);
        String productCode = ean.substring(7, 12);
        String destinationCode = ean.substring(12);

        Proveedor supplier = proveedorRepository.findById(Long.valueOf(supplierCode))
                .orElseThrow(() -> new Exception("Proveedor no encontrado"));

        Producto product = productoRepository.findById(Long.valueOf(productCode))
                .orElseThrow(() -> new Exception("Producto no encontrado"));

        Destino destino = destinoRepository.findById(Long.valueOf(destinationCode))
                .orElseThrow(() -> new Exception("Destino no encontrado"));

        return new ProductDetailsDTO(product);
    }
}
