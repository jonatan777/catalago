package com.e_commerce.catalago.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.e_commerce.catalago.models.Produto;
import com.e_commerce.catalago.repositories.ProdutoRepositoryImpl;
import com.e_commerce.catalago.repositories.ProdutoRepository_jpa;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {

 @Autowired
 private ProdutoRepository_jpa produtoRepository_jpa;

 private ProdutoRepositoryImpl produtoRepository;

    public ProdutoService(ProdutoRepositoryImpl produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

 
    public List<Produto> listAll() {
       return produtoRepository.findAllProdutos();
    }    
    public List<Produto> listNomes() {
      return produtoRepository.findForNames();
    }
    public Produto getProdutoId(Long id) {
      return produtoRepository.findById(id);
    }
    public Produto salvar(Produto produto) {
      return produtoRepository.save(produto);
    }
    public Produto updateProduto(Produto produto, Long id) {
      return produtoRepository.update(produto, id);
    }
    public Produto findByNome(String nome){
      return produtoRepository.findByName(nome);
    }

    // buscar um usuário no banco referente ao login ou retorna um notFound
    public Optional<Produto> getProdutoNome(String nome) {
    return produtoRepository_jpa.findByNome(nome);
    }


  public void produtoDelete(Long id) {
     produtoRepository_jpa.deleteById(id);
  }


}
