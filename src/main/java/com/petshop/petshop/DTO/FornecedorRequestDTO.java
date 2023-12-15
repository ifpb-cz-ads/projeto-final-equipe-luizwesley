package com.petshop.petshop.DTO;

public record FornecedorRequestDTO (String rua, String bairro, String cidade,String cnpj, String nome, String[] telefones) {
}
