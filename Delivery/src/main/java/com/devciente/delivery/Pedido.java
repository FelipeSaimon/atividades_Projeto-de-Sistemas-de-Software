package com.devciente.delivery;

import com.devciente.delivery.cupom.CupomDescontoEntrega;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class Pedido {

    private Double taxaEntrega = 10.0;
    private Double valorPedido = 0.0;
    private LocalDate dataPedido;
    private List<Item> itens = new ArrayList<>();
    private List<CupomDescontoEntrega> cuponsDescontoEntrega = new ArrayList<>();
    private Double valorDescontoConcedido = 0.0; // Posso alterar o nome de atributo do diagrama?
    private Cliente cliente;

    public Pedido(Cliente cliente, LocalDate data) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        
        this.valorPedido += this.taxaEntrega;
    }

    public void adicionarItem(Item item) {
        if (item != null) {
            itens.add(item);
            this.valorPedido += item.getValorTotal();
        }
    }

    public void adicionarCupom(CupomDescontoEntrega cupom) {
        if (cupom == null) {
            throw new RuntimeException("Cupom inexistente!");
        }
        cuponsDescontoEntrega.add(cupom);
        valorDescontoConcedido += cupom.getValorDesconto();

    }

    public Double getTaxaEntrega() {
        if (valorDescontoConcedido <= taxaEntrega) {
            taxaEntrega -= valorDescontoConcedido;
        } else {
            taxaEntrega = 0.0;
        }
        
        return taxaEntrega;
    }

    public Double getValorPedido() {
        valorPedido -= valorDescontoConcedido;
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
