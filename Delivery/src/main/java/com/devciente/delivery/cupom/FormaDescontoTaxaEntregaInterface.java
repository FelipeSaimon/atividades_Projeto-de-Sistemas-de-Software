package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;

public interface FormaDescontoTaxaEntregaInterface {
    CupomDescontoEntrega calcularDesconto(Pedido pedido);
    boolean seAplica(Pedido pedido);
}
