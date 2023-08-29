package com.jorgeseoane.mercadona.mercadona.repository;

import com.jorgeseoane.mercadona.mercadona.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
