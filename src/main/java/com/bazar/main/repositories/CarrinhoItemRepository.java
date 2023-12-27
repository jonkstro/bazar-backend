package com.bazar.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bazar.main.models.CarrinhoItem;

@Repository
public interface CarrinhoItemRepository extends JpaRepository<CarrinhoItem, Long> {

}
