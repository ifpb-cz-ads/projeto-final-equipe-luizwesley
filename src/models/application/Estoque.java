package models.application;

import java.time.LocalDate;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private int codigoLote;
    private LocalDate dtValidade;
    private int quantidade;
    private Fornecedor fornecedor;

    public Estoque(int codigoLote, LocalDate dtValidade, int quantidade, Fornecedor fornecedor) {
        this.codigoLote = codigoLote;
        this.dtValidade = dtValidade;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public int getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(int codigoLote) {
        this.codigoLote = codigoLote;
    }

    public LocalDate getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(LocalDate dtValidade) {
        this.dtValidade = dtValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }  
}
