package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;

public interface FormaDescontoTaxaEntregaInterface {
    void calcularDesconto(Pedido pedido);
    boolean seAplica(Pedido pedido);
}
