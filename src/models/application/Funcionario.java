package models.application;

import java.util.ArrayList;
import java.util.List;

import models.secondary.Endereco;
import models.secondary.Pessoa;

public class Funcionario extends Pessoa{
    private int matricula;
    private String rg;
    private double salario;
    private Funcionario supervisor;
    private List<Servico> servicos;
    private List<Venda> vendas;

    public Funcionario(String cpf, String nome, String[] telefones, Endereco endereco, int matricula, String rg,
            double salario) {
        super(cpf, nome, telefones, endereco);
        this.matricula = matricula;
        this.rg = rg;
        this.salario = salario;
        servicos = new ArrayList<Servico>();
        vendas = new ArrayList<Venda>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcionario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Funcionario supervisor) {
        this.supervisor = supervisor;
    }


    
}
