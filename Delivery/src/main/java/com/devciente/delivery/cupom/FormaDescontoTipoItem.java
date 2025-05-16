package com.devciente.delivery.cupom;

import com.devciente.delivery.Item;
import com.devciente.delivery.Pedido;
import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTipoItem implements FormaDescontoTaxaEntregaInterface {

    Map<String, Double> descontosPorTipoItem = new HashMap<String, Double>();

    public FormaDescontoTipoItem() {
        descontosPorTipoItem.put("Alimentação", 5.00);
        descontosPorTipoItem.put("Educação", 2.00);
        descontosPorTipoItem.put("Lazer", 1.50);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        double descontoTotalPorItem = 0;

        for (Item item : pedido.getItens()) {
            String tipo = item.getTipo();
            if (descontosPorTipoItem.containsKey(tipo)) {
                descontoTotalPorItem += descontosPorTipoItem.get(tipo);
            }
        }
        return new CupomDescontoEntrega("Desconto por tipo de item", descontoTotalPorItem);
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getItens().stream().anyMatch(item
                -> descontosPorTipoItem.containsKey(item.getTipo())
        );
    }
}
