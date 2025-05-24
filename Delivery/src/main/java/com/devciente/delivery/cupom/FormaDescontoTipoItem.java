package com.devciente.delivery.cupom;

import com.devciente.delivery.Item;
import com.devciente.delivery.Pedido;
import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTipoItem implements FormaDescontoTaxaEntregaInterface {

    String tipo;
    Map<String, Double> descontosPorTipoItem = new HashMap<String, Double>();

    public FormaDescontoTipoItem() {
        descontosPorTipoItem.put("Alimentacao", 5.00);
        descontosPorTipoItem.put("Educacao", 2.00);
        descontosPorTipoItem.put("Lazer", 1.50);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        double descontoTotalPorItem = 0;

        for (Item item : pedido.getItens()) {
            tipo = item.getTipo();
            
            if (descontosPorTipoItem.containsKey(tipo)) {
                descontoTotalPorItem += descontosPorTipoItem.get(tipo);
            }
        }
        
        if(descontoTotalPorItem > 0){
            pedido.adicionarCupom(new CupomDescontoEntrega("Desconto por tipo de item", descontoTotalPorItem));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for (Item item : pedido.getItens()) {
            String tipo = item.getTipo();
            if (descontosPorTipoItem.containsKey(tipo)) {
                return true;  // Retorna true assim que encontrar um item elegível
            }
        }
        return false;  // Retorna false apenas se nenhum item for elegível
    }
}
