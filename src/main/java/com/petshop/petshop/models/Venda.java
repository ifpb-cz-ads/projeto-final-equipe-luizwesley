package com.petshop.petshop.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.petshop.petshop.secondary.FormaPagamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Venda {

    private double valor;
    @ManyToOne
    private Produto produto;
    private int quantidade;
    @ManyToOne
    @JsonBackReference(value="venda-codi")
    private VendaTotal codigoVenda;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoItemVenda;
    public Venda(double valor,Produto produto, int quantidade, VendaTotal vendaTotal) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.produto = produto;
        this.codigoVenda = vendaTotal;
    }
    
    public Venda(double valor) {
        this.valor = valor;
    }  
}
