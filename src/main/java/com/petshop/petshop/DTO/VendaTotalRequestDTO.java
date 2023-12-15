package com.petshop.petshop.DTO;

import com.petshop.petshop.secondary.FormaPagamento;

import java.util.List;

public record VendaTotalRequestDTO(Long codigoVenda, List<FormaPagamento> formasPagamento, String cliente, String funcionario) {
}
