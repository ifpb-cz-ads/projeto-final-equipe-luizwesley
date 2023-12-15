package models.application;

import java.util.ArrayList;
import java.util.List;

import models.secondary.Endereco;
import models.secondary.Pessoa;

public class Cliente extends Pessoa{
    private String email;
    private List<Pet> pets;

    public Cliente(String cpf, String nome, String[] telefones, Endereco endereco, String email) {
        super(cpf, nome, telefones, endereco);
        this.email = email;
        pets = new ArrayList<Pet>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    
    


     
}
