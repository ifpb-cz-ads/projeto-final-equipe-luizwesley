package models.secondary;

public abstract class Pessoa{
    private String cpf;
    private String nome;
    private String[] telefones;
    private Endereco endereco;
    
    
    public Pessoa(String cpf, String nome, String[] telefones, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefones = telefones;
        this.endereco = endereco;
    }
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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