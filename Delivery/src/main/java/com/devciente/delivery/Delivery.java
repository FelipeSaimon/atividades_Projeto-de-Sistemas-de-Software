/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.devciente.delivery;

import java.time.LocalDate;


/**
 *
 * @author saimon
 */
public class Delivery {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        Pedido pedido = new Pedido(new Cliente("Saimon", "Ouro", "rua 2"), LocalDate.now());
        
        pedido.adicionarItem(new Item("Feijoada", 1, 50.24, "Alimentacao"));
        pedido.adicionarItem(new Item("Caderno", 3, 10.99, "Educacao"));

        System.out.println("Itens" + pedido.getItens());
        System.out.println("Valor pedido sem descontos: " + pedido.getValorPedido());
        
        System.out.println(pedido.getCuponsDescontoEntrega());
    }
}
