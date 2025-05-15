package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;
import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTipoItem implements FormaDescontoTaxaEntregaInterface{
    Map<String, Double> descontosPorTipoItem = new HashMap<String, Double>();
    

    public FormaDescontoTipoItem(){
        descontosPorTipoItem.put("Alimentos", 2.00);
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
