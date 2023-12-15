package com.petshop.petshop.repositories;

import com.petshop.petshop.models.Venda;
import com.petshop.petshop.models.VendaTotal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaTotalRp extends CrudRepository<VendaTotal, Long> {
}
