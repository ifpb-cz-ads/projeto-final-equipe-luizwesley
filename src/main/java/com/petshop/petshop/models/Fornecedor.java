package com.petshop.petshop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.DTO.FornecedorRequestDTO;
import com.petshop.petshop.secondary.Endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString

public class Fornecedor {
    @Id
    private String cnpj;
    private String nome;
    private String[] telefones;
    private Endereco endereco;
    @OneToMany(mappedBy = "fornecedor")
    //@JsonManagedReference(value="fornecedor-produto-managed")
    private List<Produto> produtos;

    public Fornecedor(FornecedorRequestDTO data){
        this.cnpj = data.cnpj();
        this.nome = data.nome();
        this.telefones = data.telefones();
        this.endereco = new Endereco(data.rua(), data.bairro(), data.cidade());
    }

}
