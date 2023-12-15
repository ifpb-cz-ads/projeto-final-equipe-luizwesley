package models.secondary;

import java.time.LocalDate;

import interfaces.FormaPagamento;

public class CartaoCredito implements FormaPagamento{
    private String nomeTitular;
    private int numero;
    private String codigoSeguranca;
    private String bandeira;
    private LocalDate dtVencimento;
    
    public CartaoCredito(String nomeTitular, int numero, String codigoSeguranca, String bandeira,
            LocalDate dtVencimento) {
        this.nomeTitular = nomeTitular;
        this.numero = numero;
        this.codigoSeguranca = codigoSeguranca;
        this.bandeira = bandeira;
        this.dtVencimento = dtVencimento;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    
}
