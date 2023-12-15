package models.application;

import models.secondary.Endereco;

public class Fornecedor {
    private String cnpj;
    private String nome;
    private String[] telefones;
    private Endereco endereco;
    
    public Fornecedor(String cnpj, String nome, String[] telefones, Endereco endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getTelefones() {
        return telefones;
    }

    public void setTelefones(String[] telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}
