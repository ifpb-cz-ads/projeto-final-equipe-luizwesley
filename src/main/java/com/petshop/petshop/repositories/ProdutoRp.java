package com.petshop.petshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Produto;

@Repository
public interface ProdutoRp extends CrudRepository<Produto, Long>{
    
}
