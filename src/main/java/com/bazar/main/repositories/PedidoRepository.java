package com.bazar.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bazar.main.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
