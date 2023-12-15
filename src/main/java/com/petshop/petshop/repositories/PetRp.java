package com.petshop.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Pet;

@Repository
public interface PetRp extends JpaRepository<Pet, Long> {
    
}
