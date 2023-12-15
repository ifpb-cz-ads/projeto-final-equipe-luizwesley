package com.petshop.petshop.DTO;

import com.petshop.petshop.models.Funcionario;

public record FuncionarioRequestDTO (String rua, String bairro, String cidade, String cpf, String nome, String[] telefones, Long matricula, String rg, double salario) {
}
