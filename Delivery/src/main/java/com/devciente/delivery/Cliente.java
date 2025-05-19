package com.devciente.delivery;

public class Cliente {
    private String nome;
    private String tipoCliente;
    private Double fidelidade;
    private String logradouro;
    private String bairro;
    private String cidade;

    public Cliente(String nome, String tipoCliente, Double fidelidade, String logradouro, String bairro, String cidade) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.fidelidade = fidelidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public Double getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(Double fidelidade) {
        this.fidelidade = fidelidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", tipoCliente=" + tipoCliente + ", fidelidade=" + fidelidade + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }
    
    
}
