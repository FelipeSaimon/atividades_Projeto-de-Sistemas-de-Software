package com.devciente.delivery;

public class Item {
    private String nome;
    private int quantidade;
    private Double valorUnitario;
    private final String tipo;

    public Item(String nome, int quantidade, Double valorUnitario, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }
    
    public Double getValorTotal(){
        return valorUnitario * quantidade;
    }
    
    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "Item{" + "nome = " + nome + ", quantidade = " + quantidade + ", valorUnitario = " + valorUnitario + ", tipo = " + tipo + '}';
    }
    
    
}
