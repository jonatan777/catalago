package com.e_commerce.catalago.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.e_commerce.catalago.models.Imagem;



@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

	Optional<Imagem> findByName(String name);

 
}


