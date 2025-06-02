package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;

import java.time.LocalDate;

public class FormaDescontoPorPeriodoDatas implements FormaDescontoTaxaEntregaInterface{

	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private double descontoPercentual;

	public FormaDescontoPorPeriodoDatas(LocalDate dataInicio, LocalDate dataFinal, double descontoPercentual) {
		this.dataInicio = LocalDate.of(2023, 10, 1);
		this.dataFinal = LocalDate.of(2023, 10, 31);
	}

	@Override
	public void calcularDesconto(Pedido pedido) {

	}

	@Override
	public boolean seAplica(Pedido pedido) {
		return false;
	}
}
