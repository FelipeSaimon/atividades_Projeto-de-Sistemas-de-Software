package com.devciente.delivery;

import com.devciente.delivery.cupom.CupomDescontoEntrega;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Double taxaEntrega = 10.0;
    private Double valorPedido = 0.0;
    private LocalDate dataPedido;
    private List<Item> itens = new ArrayList<>();
    private List<CupomDescontoEntrega> cuponsDescontoEntrega = new ArrayList<>();
    private Double valorDescontoConcedido; // Posso alterar o nome de atributo do diagrama?
    private Cliente cliente;
        
    public Pedido(Cliente cliente, LocalDate data ){
       this.cliente = cliente;
       this.dataPedido = dataPedido;
    }
    
    public void adicionarItem(Item item){
        if(item != null)
            itens.add(item);
            this.valorPedido += item.getValorTotal();
    }
    
    public void adicionarCupom(CupomDescontoEntrega cupom){
        cuponsDescontoEntrega.add(cupom);
    }
    
    // Para que serveria esse método?
    // Considerando que, o módulo de cupons gera os cupons, aplicar cupom seria,
    // pegar os valores totais de cada cupom e somar ao valorDescontoConcedido?
    // e por fim descontar esse total na taxa?
    public void aplicarCupom(CupomDescontoEntrega cupom){
        //verificar se o cliente e se o pedido existe,
        //verificar os tipos de descontos o pedido tem
        //adicionar a uma lista de cupons aplicaveis
        //descontar o valor do cupom na taxa fixa
    }

    public Double getTaxaEntrega() {
        return taxaEntrega;
    }

    public Double getValorPedido() {
        return valorPedido;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Double getValorDescontoConcedido() {
        return valorDescontoConcedido;
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
        return cuponsDescontoEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
