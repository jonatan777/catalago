package com.e_commerce.catalago.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import com.e_commerce.catalago.exceptions.IdExeption;
import com.e_commerce.catalago.models.Produto;
import com.e_commerce.catalago.service.ProdutoService;

import lombok.val;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
     //buscar todos produtos não ordenados
	@GetMapping(path = { "/all" })
	public List<Produto> findAllProdutos() {
		return produtoService.listAll();
	}
    // buscar todos registros pelo nome 
	@GetMapping(path = { "/allNome" })
	public List<Produto> findProdutoNomes() {
		return produtoService.listNomes();
	}
	 //buscar um unico registro no banco pela nome
     @GetMapping(path = {"/buscar/{nome}"})
    public ResponseEntity<Produto> getNomeDB(@PathVariable("nome") String nome) throws NullPointerException, IdExeption {
	try{
		if(nome != null && nome != ""){
        final Optional<Produto> produto = produtoService.getProdutoNome(nome);
		 return produto
               .map(record -> ResponseEntity.ok().body(record))
               .orElse(ResponseEntity.notFound().build()); 
		}else{

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}          
	}catch (NullPointerException e) {
			throw new ResourceAccessException(nome);
		}
    }

     // buscar registro por ID
	@GetMapping(path = { "/{id}" })
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) throws NullPointerException, IdExeption {

		try {
			Produto produto = produtoService.getProdutoId(id);
			if (produto == null) {
				return new ResponseEntity<>( HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(produto, HttpStatus.OK);
			}
		} catch (NullPointerException e) {
			throw new IdExeption();
		}
	}
        //adicionar um novo produto ao banco 
    @PostMapping(path = { "/salvar" })
    public ResponseEntity<Produto> salvar(@RequestBody @val Produto produto) {

		if(produto != null){
           Produto produto2 = produtoService.salvar(produto);
        return new ResponseEntity<>(produto2, HttpStatus.CREATED);
		}
        return new ResponseEntity<>(produto, HttpStatus.EXPECTATION_FAILED);
    }
	// atualizar um registro da tabela(jogadores)
    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Produto produto)  {

       Produto produto2 = produtoService.getProdutoId(id);
           
              produto2.setImagem(produto.getImagem()); 
              produto2.setNome(produto.getNome());  
              produto2.setDescricao(produto.getDescricao());
			  produto2.setPreco(produto.getPreco());
			  produto2.setSeguimento(produto.getSeguimento());
              produto2.setQuantidade(produto.getQuantidade());
			  
              Produto updated = produtoService.salvar(produto2);
              return ResponseEntity.ok().body(updated);    
      }	

	  // deletando registro da tabela
    @DeleteMapping(path ={"/{id}"})
     public ResponseEntity <?> delete(@PathVariable Long id) {
     Produto produto = produtoService.getProdutoId(id);

	 if(produto != null){
       produtoService.produtoDelete(id);
	   return new ResponseEntity<>(produto, HttpStatus.FOUND);
	 }
    String resposta = "produto não encontrado";
	return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);
} 

}