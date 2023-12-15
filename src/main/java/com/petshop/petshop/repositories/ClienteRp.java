package com.petshop.petshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Cliente;

@Repository
public interface ClienteRp extends CrudRepository<Cliente, String> {
    Cliente findByCpf(String cpf);
}
