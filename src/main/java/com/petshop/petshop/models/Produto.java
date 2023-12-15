package com.petshop.petshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.DTO.ProdutoRequestDTO;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private double preco;
    private int estoque = 0;
    @ManyToOne
    @JsonBackReference(value="produto-fornecedor-back")
    private Fornecedor fornecedor;


    public Produto (ProdutoRequestDTO data){
        this.nome = data.nome();
        this.preco = data.preco();
    }


}


