package com.devciente.delivery.DescontoCupomUnicoPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoPedidoService {
    private List<CupomDescontoPedido> cuponsDescontoPedido = new ArrayList<>();

    public void adicionaCupom(String codigoCupom, Double percentualDesconto, LocalDateTime dataInicial, LocalDateTime dataEncerramento){
        cuponsDescontoPedido.add(new CupomDescontoPedido(codigoCupom, percentualDesconto, dataInicial, dataEncerramento));
    }


}
