package com.jorgeseoane.mercadona.mercadona.repository;

import com.jorgeseoane.mercadona.mercadona.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
}
