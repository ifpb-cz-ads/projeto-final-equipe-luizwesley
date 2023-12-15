package com.petshop.petshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Fornecedor;

@Repository
public interface FornecedorRp extends CrudRepository<Fornecedor, String>{
    Fornecedor findByCnpj(String cnpj);
}
