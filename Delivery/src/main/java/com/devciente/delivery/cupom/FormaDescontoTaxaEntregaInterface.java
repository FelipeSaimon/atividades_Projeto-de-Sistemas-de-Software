package com.devciente.delivery.cupom;

import com.devciente.delivery.model.Pedido;

public interface FormaDescontoTaxaEntregaInterface {
    void calcularDesconto(Pedido pedido);
    boolean seAplica(Pedido pedido);
}
