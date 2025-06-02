package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;

import java.util.HashMap;
import java.util.Map;

public class FormaDescontoPorBairro implements FormaDescontoTaxaEntregaInterface {

    String bairroCliente;
    Map<String, Double> descontosPorBairro = new HashMap<String, Double>();

    public FormaDescontoPorBairro() {
        descontosPorBairro.put("Bela Vista", 3.00);
        descontosPorBairro.put("Centro", 2.00);
        descontosPorBairro.put("Cidade Maravilhosa", 1.50);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        double descontoTotalPorBairro = 0;

        bairroCliente = pedido.getCliente().getBairro();

        if (bairroCliente != null) {
            // Verifica se o cliente tem um bairro definido
            if (descontosPorBairro.containsKey(bairroCliente)) {
                // e se esse bairro está na lista de descontos, e insere o desconto
                descontoTotalPorBairro += descontosPorBairro.get(bairroCliente);
                pedido.adicionarCupom(new CupomDescontoEntrega("Desconto por bairro", descontoTotalPorBairro));
            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        bairroCliente = pedido.getCliente().getBairro();

        if (bairroCliente != null) {
            // Verifica se o cliente tem um bairro definido
            return descontosPorBairro.containsKey(bairroCliente);
        }
        return false;
    }
}
