package com.devciente.delivery;

import com.devciente.delivery.cupom.CupomDescontoEntrega;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Double taxaEntrega = 10.0;
    private Double valorPedido;
    private Date dataPedido;
    private List<Item> itens;
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private Double valorDescontoConcedido; // Posso alterar o nome de atributo do diagrama?
    private Cliente cliente;
        
    public Pedido(Cliente cliente, Date data ){
       
    }
    
    public void adicionarItem(Item item){
        if(item != null)
            itens.add(item);
    }
    
    public void adicionarCupom(CupomDescontoEntrega cupom){
        cuponsDescontoEntrega.add(cupom);
    }
    
    public void aplicarCupom(CupomDescontoEntrega cupom){
        
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
