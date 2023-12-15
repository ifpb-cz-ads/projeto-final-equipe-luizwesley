package com.petshop.petshop.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Serviço")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Servico {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String tipo;
    private double valor;
//
    
}
