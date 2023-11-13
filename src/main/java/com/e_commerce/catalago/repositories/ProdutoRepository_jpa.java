package com.e_commerce.catalago.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.catalago.models.Produto;


@Repository
public interface ProdutoRepository_jpa  extends JpaRepository<Produto, Long>{
    
Optional<Produto> findByNome(String nome);
}