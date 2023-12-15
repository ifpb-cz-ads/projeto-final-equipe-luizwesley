package com.petshop.petshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ServicoRealizado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @ManyToOne
    private Servico servico;
    @ManyToOne
    private Pet pet;
    @ManyToOne
    //@JsonManagedReference(value="servicorealizado-func-managed")
    private Funcionario funcionario;

    public ServicoRealizado(Servico servico, Pet pet, Funcionario funcionario) {
        this.servico = servico;
        this.pet = pet;
        this.funcionario = funcionario;
    }
}
