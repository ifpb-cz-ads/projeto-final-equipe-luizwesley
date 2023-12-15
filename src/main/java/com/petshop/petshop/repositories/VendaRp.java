package com.petshop.petshop.repositories;

import com.petshop.petshop.models.Cliente;
import com.petshop.petshop.models.VendaTotal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.petshop.petshop.models.Venda;

import java.util.ArrayList;

@Repository
public interface VendaRp extends CrudRepository<Venda, Long>{
    //ArrayList<Venda> findAllByCodigoVenda(Long codigoVenda);
}
