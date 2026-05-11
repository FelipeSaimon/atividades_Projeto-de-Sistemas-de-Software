package com.devciente.delivery.FormasDescontoTaxaEntrega;

import com.devciente.delivery.model.Pedido;

public interface FormaDescontoTaxaEntregaInterface {
    void calcularDesconto(Pedido pedido);
    boolean seAplica(Pedido pedido);
}
