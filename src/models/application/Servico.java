package models.application;

public class Servico {
    private static int codigo = 0;
    private String tipo;
    private double valor;
    private Pet pet;

    public Servico(String tipo, double valor, Pet pet) {
        this.tipo = tipo;
        this.valor = valor;
        this.pet = pet; 
        codigo++;
    }

    public static int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
 }

    

