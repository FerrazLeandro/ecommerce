package br.com.tech4me.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.ecommerce.model.ItemVenda;

public interface ItemVendaRepository extends MongoRepository<ItemVenda, String> {
    
}
