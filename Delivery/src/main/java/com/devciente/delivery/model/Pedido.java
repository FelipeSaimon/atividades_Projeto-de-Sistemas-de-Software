package com.devciente.delivery.model;

import com.devciente.delivery.FormasDescontoTaxaEntrega.model.CupomDescontoTaxaEntrega;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class Pedido {

    private Double taxaEntrega = 10.0;
    private Double valorPedido = 0.0;
    private LocalDate dataPedido;
    private List<Item> itens = new ArrayList<>();
    private List<CupomDescontoTaxaEntrega> cuponsDescontoEntrega = new ArrayList<>();
    private Double valorDescontoConcedido = 0.0; // Posso alterar o nome de atributo do diagrama?
    private Cliente cliente;

    private Double percentualDescontoPedido;
    private String codigoCupom;

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

    public void adicionarCupom(CupomDescontoTaxaEntrega cupom) {
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

    public Double getPercentualDescontoPedido(){
        return percentualDescontoPedido;
    }

    public Double getValorDescontoConcedido() {
        return valorDescontoConcedido;
    }

    public List<CupomDescontoTaxaEntrega> getCuponsDescontoEntrega() {
        return cuponsDescontoEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }
}
