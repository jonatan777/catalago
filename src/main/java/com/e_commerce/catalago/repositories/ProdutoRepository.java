package com.e_commerce.catalago.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.e_commerce.catalago.models.Produto;
import lombok.NonNull;

@Repository
public interface ProdutoRepository {
    
    Produto save(@NonNull Produto produto);
    Produto update(Produto produto, Long id);
    List<Produto> findAllProdutos();
    Produto findById(@NonNull Long id);
    Produto findByName(@NonNull String name);
    List<Produto> findForNames();
    List<Produto> findForSalgados();
    List<Produto> findForDoces();
    List<Produto> findForHamburgueres();
    List<Produto> findForSanduiches();
}