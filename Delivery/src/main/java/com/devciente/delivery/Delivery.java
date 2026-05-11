package com.devciente.delivery;

import com.devciente.delivery.FormasDescontoTaxaEntrega.service.CalculadoraDescontoTaxaEntregaService;
import com.devciente.delivery.model.Cliente;
import com.devciente.delivery.model.Item;
import com.devciente.delivery.model.Pedido;

import java.time.LocalDate;


/**
 *
 * @author saimon
 */
public class Delivery {

    public static void main(String[] args) {

        Pedido pedido = new Pedido(new Cliente("Saimon", "Ouro", "Bela Vista"), LocalDate.now());

        pedido.adicionarItem(new Item("Feijoada", 1, 50.24, "Alimentacao"));
        pedido.adicionarItem(new Item("Caderno", 3, 10.99, "Educacao"));

        CalculadoraDescontoTaxaEntregaService calculadora = new CalculadoraDescontoTaxaEntregaService();

        calculadora.calcularDesconto(pedido);

        System.out.println("Itens: " + pedido.getCuponsDescontoEntrega());

        System.out.println("taxa atual " + pedido.getTaxaEntrega());

    }
}
