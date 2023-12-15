package models.application;

import java.util.ArrayList;
import java.util.List;

import interfaces.FormaPagamento;

public class Venda {
    private static int codigo = 0;
    private double valor;
    private FormaPagamento formaPagamento;
    private List<Produto> produtos;

    
    public Venda(double valor, FormaPagamento formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        produtos = new ArrayList<Produto>();
        codigo++;
    }
    
    public Venda(double valor) {
        this.valor = valor;
        produtos = new ArrayList<Produto>();
        codigo++;
    }

    public int getCodigo() {
        return codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    
}
