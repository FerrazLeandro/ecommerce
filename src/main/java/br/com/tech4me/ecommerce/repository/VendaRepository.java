package br.com.tech4me.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.ecommerce.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, String> {

    
}
