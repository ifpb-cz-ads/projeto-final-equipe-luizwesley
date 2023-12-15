package com.petshop.petshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Servico;

@Repository
public interface ServicoRp extends CrudRepository<Servico, Long>{
    
}
