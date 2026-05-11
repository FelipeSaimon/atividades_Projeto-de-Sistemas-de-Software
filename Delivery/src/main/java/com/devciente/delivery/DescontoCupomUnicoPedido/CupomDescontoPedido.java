package com.devciente.delivery.DescontoCupomUnicoPedido;

import java.time.LocalDateTime;

public class CupomDescontoPedido {
    private String codigoCupom;
    private Double percentualDescontoCupom;
    private LocalDateTime dataInicial;
    private LocalDateTime dataEncerramento;

    public CupomDescontoPedido(String codigoCupom, Double percentualDescontoCupom, LocalDateTime dataInicial, LocalDateTime dataEncerramento){
        this.codigoCupom = codigoCupom;
        this.percentualDescontoCupom = percentualDescontoCupom;
        this.dataInicial = dataInicial;
        this.dataEncerramento = dataEncerramento;
    }

    public String getCodigoCupom() {
        return codigoCupom;
    }

    public double getPercentualDescontoCupom() {
        return percentualDescontoCupom;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }



    @Override
    public String toString() {
        return "Cupom de desconto do pedido: \n Codigo do cupom " + codigoCupom + "\npercentual do desconto " + percentualDescontoCupom + "\nValidade de " + dataInicial + " até " + dataEncerramento;
    }
}
