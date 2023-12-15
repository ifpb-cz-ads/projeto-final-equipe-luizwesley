package com.petshop.petshop.DTO;

import com.petshop.petshop.models.Produto;
import com.petshop.petshop.models.Venda;
import com.petshop.petshop.models.VendaTotal;
import com.petshop.petshop.secondary.FormaPagamento;

import java.util.ArrayList;
import java.util.List;

public record VendaRequestDTO (Long codigo, int quantidade, double valor, VendaTotal codigoVenda) {
}
