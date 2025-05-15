package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;
import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTipoItem implements FormaDescontoTaxaEntregaInterface{
    private Map<String, Double> descontosPorTipoItem = new HashMap<String, Double>();
    
    descontos

//    public FormaDescontoTipoItem(){
//        for(FormaDescontoTipoItem desconto : )
//    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
