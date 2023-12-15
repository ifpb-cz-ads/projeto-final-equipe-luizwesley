package com.petshop.petshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Funcionario;

@Repository
public interface FuncionarioRp extends CrudRepository<Funcionario, String> {
    
}
