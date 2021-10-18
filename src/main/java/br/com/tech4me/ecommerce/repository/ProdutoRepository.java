package br.com.tech4me.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.ecommerce.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{
    
}
