package com.jorgeseoane.mercadona.mercadona;

import com.jorgeseoane.mercadona.mercadona.model.Destino;
import com.jorgeseoane.mercadona.mercadona.model.ProductDetailsDTO;
import com.jorgeseoane.mercadona.mercadona.model.Producto;
import com.jorgeseoane.mercadona.mercadona.model.Proveedor;
import com.jorgeseoane.mercadona.mercadona.repository.DestinoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProductoRepository;
import com.jorgeseoane.mercadona.mercadona.repository.ProveedorRepository;
import com.jorgeseoane.mercadona.mercadona.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MercadonaApplicationTests {
    @Mock
    private ProveedorRepository proveedorRepository;

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private DestinoRepository destinoRepository;

    @InjectMocks
    private ProductoService productService;

    @BeforeEach
    public void setup() {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1234567L);
        proveedor.setNombre("Hacendado");
        Producto producto = new Producto();
        producto.setId_producto(12345L);
        producto.setNombre("Jamón");
        Destino destino = new Destino();
        destino.setId(1L);

        Mockito.when(proveedorRepository.findById(1234567L)).thenReturn(Optional.of(proveedor));
        Mockito.when(productoRepository.findById(12345L)).thenReturn(Optional.of(producto));
        Mockito.when(destinoRepository.findById(1L)).thenReturn(Optional.of(destino));
    }

    @Test
    @DisplayName("Test getProductoDetails - Caso Exitoso")
    public void testGetProductoDetails_Success() throws Exception {
        ProductDetailsDTO details = productService.getProductoDetails("1234567123451");
        assertNotNull(details);
    }

    @Test
    @DisplayName("Test getProductoDetails - EAN Incorrecto")
    public void testGetProductoDetails_InvalidEAN() {
        assertThrows(Exception.class, () -> productService.getProductoDetails("12345671234"));
        assertThrows(Exception.class, () -> productService.getProductoDetails("123456712345AB"));
    }

    @Test
    @DisplayName("Test getProductoDetails - Proveedor No Encontrado")
    public void testGetProductoDetails_ProveedorNotFound() {
        assertThrows(Exception.class, () -> productService.getProductoDetails("1111111123451"));
    }

    @Test
    @DisplayName("Test getProductoDetails - Producto No Encontrado")
    public void testGetProductoDetails_ProductoNotFound() {
        assertThrows(Exception.class, () -> productService.getProductoDetails("1234567111111"));
    }

    @Test
    @DisplayName("Test getProductoDetails - Destino No Encontrado")
    public void testGetProductoDetails_DestinoNotFound() {
        assertThrows(Exception.class, () -> productService.getProductoDetails("1234567123450"));
    }

}
