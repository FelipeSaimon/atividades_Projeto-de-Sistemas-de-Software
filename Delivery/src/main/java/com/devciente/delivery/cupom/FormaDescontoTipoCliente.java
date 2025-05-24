package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;

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
                pedido.adicionarCupom(new CupomDescontoEntrega("Desconto por tipo de cliente", descontoTotalPorTipoCliente));
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
