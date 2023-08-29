package com.jorgeseoane.mercadona.mercadona.controller;

import com.jorgeseoane.mercadona.mercadona.model.Producto;
import com.jorgeseoane.mercadona.mercadona.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/crud")
@RestController
public class CrudController {


    private CrudService crudService;
    @Autowired
    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        producto = crudService.createOrUpdate(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto task) {
        task = crudService.createOrUpdate(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") long id) {
        Optional<Producto> task = crudService.findById(id);
        if (task.isPresent()) {
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducto() {
        try {
            List<Producto> productoList = crudService.findAll();
            return new ResponseEntity<>(productoList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") long id) {
        try {
            if(crudService.deleteProducto(id))
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
