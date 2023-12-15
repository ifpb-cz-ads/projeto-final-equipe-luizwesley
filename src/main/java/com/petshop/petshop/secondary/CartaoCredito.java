package com.petshop.petshop.secondary;

import java.time.LocalDate;

import com.petshop.petshop.models.Venda;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoCredito extends FormaPagamento{
    private String nomeTitular;
    @Id
    private int numero;
    private String codigoSeguranca;
    private String bandeira;
    private LocalDate dtVencimento;
    @ManyToOne
    private Venda venda;

    
}
