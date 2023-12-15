package com.petshop.petshop.DTO;

public record ClienteRequestDTO(String rua, String bairro, String cidade, String cpf, String nome, String[] telefones, String email) {

}
