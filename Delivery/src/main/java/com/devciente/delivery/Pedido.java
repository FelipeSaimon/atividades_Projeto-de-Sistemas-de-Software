package com.devciente.delivery;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Double taxaEntrega = 10.0;
    private Double valorPedido;
    private Date dataPedido;
    private List<Item> itens;
    private Double valorDescontoConcedido; // Posso alterar o nome de atributo do diagrama?
    
    public Pedido(Cliente cliente, Date data ){
       
    }
    
    public void adicionarItem(Item item){
        if(item != null)
            itens.add(item);
    }
    
    // o desconto passado por parametro vem de onde?
    public void aplicarDesconto(){
        // Pegar o tipo de desconto
        // pegar o valor do desconto pelo tipo
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
    
    
            
}
