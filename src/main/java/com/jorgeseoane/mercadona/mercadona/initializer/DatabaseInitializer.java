package com.jorgeseoane.mercadona.mercadona.initializer;

import com.jorgeseoane.mercadona.mercadona.model.Destino;
import com.jorgeseoane.mercadona.mercadona.model.Producto;
import com.jorgeseoane.mercadona.mercadona.model.Proveedor;
import com.jorgeseoane.mercadona.mercadona.repository.DestinoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProductoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProveedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;
    private final DestinoRepository destinoRepository;

    public DatabaseInitializer(ProductoRepository productRepository, ProveedorRepository supplierRepository, DestinoRepository destinoRepository) {
        this.productoRepository = productRepository;
        this.proveedorRepository = supplierRepository;
        this.destinoRepository = destinoRepository;
    }

    @Override
    public void run(String... args) {

        Destino destino1 = new Destino(1L,"Tiendas Mercadona España","Barcelona");
        destinoRepository.save(destino1);
        Destino destino2 = new Destino(2L,"Tiendas Mercadona España","Valencia");
        destinoRepository.save(destino2);
        Destino destino3 = new Destino(3L,"Tiendas Mercadona España","Murcia");
        destinoRepository.save(destino3);
        Destino destino4 = new Destino(4L,"Tiendas Mercadona España","Sevilla");
        destinoRepository.save(destino4);
        Destino destino5 = new Destino(5L,"Tiendas Mercadona España","Madrid");
        destinoRepository.save(destino5);
        Destino destino6 = new Destino(6L,"Tiendas Mercadona Portugal","loquesea");
        destinoRepository.save(destino6);
        Destino destino8 = new Destino(8L,"Almacenes","loquesea");
        destinoRepository.save(destino8);
        Destino destino9 = new Destino(9L,"Oficinas Mercadona","loquesea");
        destinoRepository.save(destino9);
        Destino destino0 = new Destino(0L,"Colmenas","loquesea");
        destinoRepository.save(destino0);

        Proveedor proveedor1 = new Proveedor(8437008L, "Hacendado", "Hace de todo");
        proveedorRepository.save(proveedor1);

        Proveedor proveedor2 = new Proveedor(8437101L, "El Pozo", "Productos carnicos");
        proveedorRepository.save(proveedor2);



        Producto producto1 = new Producto(12345L, "8437008123454", "Jabón Hacendado","jabón del mercadona", proveedor1, destino4);
        productoRepository.save(producto1);

        Producto producto2 = new Producto(54321L, "8437101543216", "Fuet El Pozo","fuet del mercadona", proveedor2, destino6);
        productoRepository.save(producto2);




    }
}
