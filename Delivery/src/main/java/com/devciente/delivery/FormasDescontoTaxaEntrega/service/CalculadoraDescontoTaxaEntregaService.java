package com.devciente.delivery.FormasDescontoTaxaEntrega.service;

import com.devciente.delivery.model.Pedido;
import com.devciente.delivery.FormasDescontoTaxaEntrega.*;
import com.devciente.delivery.FormasDescontoTaxaEntrega.model.CupomDescontoTaxaEntrega;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoTaxaEntregaService {
    
    List<FormaDescontoTaxaEntregaInterface> formasDesconto = new ArrayList<>();
    
    public CalculadoraDescontoTaxaEntregaService() {
        formasDesconto.add(new FormaDescontoPorBairro());
        formasDesconto.add(new FormaDescontoTipoCliente());
        formasDesconto.add(new FormaDescontoTipoItem());
    }
    
    public void calcularDesconto(Pedido pedido) {
        List<CupomDescontoTaxaEntrega> cupons = new ArrayList<>();
        
        for (FormaDescontoTaxaEntregaInterface formaDesconto : formasDesconto) {
            if (formaDesconto.seAplica(pedido)) {
                formaDesconto.calcularDesconto(pedido);
            }
        }
        
    }
}
