package com.devciente.delivery.cupom.enity;

import java.time.LocalDate;

public class CupomDescontoPorDatas {
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private double descontoPercentual;

	public CupomDescontoPorDatas(LocalDate dataInicio, LocalDate dataFinal, double descontoPercentual) {
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.descontoPercentual = descontoPercentual;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public double getDescontoPercentual() {
		return descontoPercentual;
	}

	public void setDescontoPercentual(double descontoPercentual) {
		this.descontoPercentual = descontoPercentual;
	}

	@Override
	public String toString() {
		return "CupomDescontoPorDatas{" +
				"dataFinal=" + dataFinal +
				", dataInicio=" + dataInicio +
				", descontoPercentual=" + descontoPercentual +
				'}';
	}
}
