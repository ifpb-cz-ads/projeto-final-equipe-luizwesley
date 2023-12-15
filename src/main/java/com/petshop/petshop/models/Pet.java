package com.petshop.petshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.Controllers.ClienteController;
import com.petshop.petshop.DTO.ClienteCpfDTO;
import com.petshop.petshop.DTO.PetRequestDTO;
import com.petshop.petshop.repositories.ClienteRp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import lombok.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Pet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo; 
    private String nome;
    private String especie;
    private String sexo;
    @ManyToOne
    @JoinColumn(name = "tutor")
    @JsonManagedReference(value="Cliente-pet-managed")
    private Cliente tutor;


    public Pet (PetRequestDTO data){

        this.nome = data.nome();
        this.especie = data.especie();
        this.sexo = data.sexo();
    }
    
}
