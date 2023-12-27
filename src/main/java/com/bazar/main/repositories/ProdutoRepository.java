package com.bazar.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bazar.main.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
