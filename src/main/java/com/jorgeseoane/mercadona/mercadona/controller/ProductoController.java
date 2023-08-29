package com.jorgeseoane.mercadona.mercadona.controller;

import com.jorgeseoane.mercadona.mercadona.model.ProductDetailsDTO;
import com.jorgeseoane.mercadona.mercadona.service.ProductoService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productService;

    @Autowired
    public ProductoController(ProductoService productService) {
        this.productService = productService;
    }

    @GetMapping("/{ean}")
    public ResponseEntity<ProductDetailsDTO> getProductDetails(@PathVariable @Pattern(regexp = "\\d{13}", message = "El EAN debe ser un número de 13 dígitos") String ean) {
        try {
            ProductDetailsDTO productDetails = productService.getProductoDetails(ean);
            return ResponseEntity.ok(productDetails);
        } catch (MethodArgumentNotValidException a){
            return new ResponseEntity<>(new ProductDetailsDTO(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ProductDetailsDTO(), HttpStatus.NO_CONTENT);
        }
    }
}
