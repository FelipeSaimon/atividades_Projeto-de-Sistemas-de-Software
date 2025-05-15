package com.devciente.delivery.cupom;

class CupomDescontoEntrega {
    private String nomeFormaDeDesconto;
    private double valorDesconto;

    public CupomDescontoEntrega(String nomeFormaDeDesconto, double valorDesconto) {
        this.nomeFormaDeDesconto = nomeFormaDeDesconto;
        this.valorDesconto = valorDesconto;
    }

    public String getNomeFormaDeDesconto() {
        return nomeFormaDeDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" + "nomeFormaDeDesconto=" + nomeFormaDeDesconto + ", valorDesconto=" + valorDesconto + '}';
    }
        
}
