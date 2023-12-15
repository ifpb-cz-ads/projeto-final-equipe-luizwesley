package com.petshop.petshop.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.DTO.ClienteRequestDTO;
import com.petshop.petshop.secondary.Endereco;
import com.petshop.petshop.secondary.Pessoa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Cliente extends Pessoa{
    private String email;
    @OneToMany(mappedBy = "tutor", fetch = FetchType.EAGER)
    @JsonBackReference(value="pet-cliente-back")
    private List<Pet> pets;
    @OneToMany(mappedBy = "cliente")
    @JsonBackReference(value="vendatotal-cliente-back")
    private List<VendaTotal> compras;

    
    public Cliente(String cpf, String nome, String[] telefones, Endereco endereco,String email) {
        super(cpf, nome, telefones, endereco);
        this.email = email;
        pets = new ArrayList<Pet>();
    }



    @Override
    public String toString() {
        return super.toString() + "Cliente [email=" + email;
    }

    public Cliente(ClienteRequestDTO data){
        super(data.cpf(), data.nome(), data.telefones(), new Endereco(data.rua(), data.bairro(), data.cidade()));
        this.email = data.email();
    }
}
