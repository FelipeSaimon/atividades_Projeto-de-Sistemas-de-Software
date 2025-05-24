/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.devciente.delivery;

import com.devciente.delivery.cupom.CalculadoraDescontoService;
import java.time.LocalDate;


/**
 *
 * @author saimon
 */
public class Delivery {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        Pedido pedido = new Pedido(new Cliente("Saimon", "Ouro", "Bela Vista"), LocalDate.now());
        
        pedido.adicionarItem(new Item("Feijoada", 1, 50.24, "Alimentacao"));
        pedido.adicionarItem(new Item("Caderno", 3, 10.99, "Educacao"));

        CalculadoraDescontoService calculadora = new CalculadoraDescontoService();
        
        calculadora.calcularDesconto(pedido);
        
        System.out.println("Itens: " + pedido.getCuponsDescontoEntrega());
        
        System.out.println("taxa atual " + pedido.getTaxaEntrega());
      
    }
}
