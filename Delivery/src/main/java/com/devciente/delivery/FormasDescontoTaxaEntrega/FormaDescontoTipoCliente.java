package com.devciente.delivery.FormasDescontoTaxaEntrega;

import com.devciente.delivery.model.Pedido;
import com.devciente.delivery.FormasDescontoTaxaEntrega.model.CupomDescontoTaxaEntrega;

import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTipoCliente implements FormaDescontoTaxaEntregaInterface {

    Map<String, Double> descontosPortipoCliente = new HashMap<String, Double>();
    String tipoCliente;

    public FormaDescontoTipoCliente() {
        descontosPortipoCliente.put("Ouro", 3.00);
        descontosPortipoCliente.put("Prata", 2.00);
        descontosPortipoCliente.put("Bronze", 1.00);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        double descontoTotalPorTipoCliente = 0;

        // Verifica se o cliente tem um tipo definido
        if (pedido.getCliente().getTipoCliente() != null) {
            tipoCliente = pedido.getCliente().getTipoCliente();
            // e se esse tipo está na lista de descontos, e insere o desconto
            if (descontosPortipoCliente.containsKey(tipoCliente)) {
                descontoTotalPorTipoCliente += descontosPortipoCliente.get(tipoCliente);
                pedido.adicionarCupom(new CupomDescontoTaxaEntrega("Desconto por tipo de cliente", descontoTotalPorTipoCliente));
            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        if (pedido.getCliente().getTipoCliente() != null) {
            return descontosPortipoCliente.containsKey(pedido.getCliente().getTipoCliente());
        }
        return false;
    }
}
