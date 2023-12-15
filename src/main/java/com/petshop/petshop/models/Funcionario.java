package com.petshop.petshop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.DTO.FuncionarioRequestDTO;
import com.petshop.petshop.secondary.Endereco;
import com.petshop.petshop.secondary.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Funcionario extends Pessoa implements Serializable {
    private Long matricula;
    private String rg;
    private double salario;
    @ManyToOne
    private Funcionario supervisor;
    @OneToMany(mappedBy = "funcionario")
    @JsonBackReference(value="funcionario-servicorealizado-back")
    private List<ServicoRealizado> servicosRealizados;
    @OneToMany(mappedBy = "funcionario")
    @JsonBackReference(value="funcionario-vendatotal-back")
    private List<VendaTotal> vendas;

    public Funcionario(String cpf, String nome, String[] telefones, Endereco endereco, Long matricula, String rg,
            double salario) {
        super(cpf, nome, telefones, endereco);
        this.matricula = matricula;
        this.rg = rg;
        this.salario = salario;
        servicosRealizados = new ArrayList<ServicoRealizado>();
        vendas = new ArrayList<VendaTotal>();
    }

    public Funcionario (FuncionarioRequestDTO data){
        super(data.cpf(), data.nome(), data.telefones(), new Endereco(data.rua(), data.bairro(), data.cidade()));
        this.matricula = data.matricula();
        this.rg = data.rg();
        this.salario = data.salario();

    }
}
