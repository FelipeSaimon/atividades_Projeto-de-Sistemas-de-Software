package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoService {

    List<FormaDescontoTaxaEntregaInterface> formasDesconto = new ArrayList<>();

    public CalculadoraDescontoService(){
        formasDesconto.add(new FormaDescontoPorBairro());
        formasDesconto.add(new FormaDescontoTipoCliente());
        formasDesconto.add(new FormaDescontoTipoItem());
    }


    public List<CupomDescontoEntrega> calcularDesconto(Pedido pedido){
        List<CupomDescontoEntrega> cupons = new ArrayList<>();

        for (FormaDescontoTaxaEntregaInterface formaDesconto : formasDesconto) {
            if (formaDesconto.seAplica(pedido)) {
                CupomDescontoEntrega cupom = formaDesconto.calcularDesconto(pedido);
                cupons.add(cupom);
            }
        }

        return cupons;
    }
}
