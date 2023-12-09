package com.e_commerce.catalago.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.stereotype.Repository;
import com.e_commerce.catalago.models.Produto;
import java.util.List;



@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {
    

    @PersistenceContext
    private EntityManager entityManager;


    public ProdutoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Produto save(@NonNull Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Override
    @Transactional
    public Produto update(Produto produto, Long id) {
       produto = entityManager.find(Produto.class, id);
        return entityManager.merge(produto);
    }
    
      @Override
    @Transactional         
    public List<Produto> findAllProdutos() {
        String qlString = "SELECT e FROM Produto e WHERE e.id != 0 ORDER BY e.id ASC";
        TypedQuery<Produto> query = entityManager.createQuery(qlString, Produto.class);
        return query.getResultList();
    }
   
     @Override
    @Transactional         
    public List<Produto> findForNames() {
        String qlString = "SELECT e FROM Produto e WHERE e.nome != null ORDER BY e.nome ASC ";
        TypedQuery<Produto> query = entityManager.createQuery(qlString, Produto.class);
        return query.getResultList();
    }

    @Override
    public Produto findById(@NotNull Long id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    public Produto findByName(String nome) {

       String qlString = "SELECT e FROM Produto e WHERE e.nome = nome";
       TypedQuery<Produto> query = entityManager.createQuery(qlString, Produto.class);
       return query.getSingleResult();

    }

}
