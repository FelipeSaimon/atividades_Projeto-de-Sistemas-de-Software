package com.devciente.delivery.cupom;

import com.devciente.delivery.Pedido;
import com.devciente.delivery.cupom.enity.CupomDescontoPorDatas;

import java.time.LocalDate;
import java.util.List;

public class FormaDescontoPorPeriodoDatas implements FormaDescontoTaxaEntregaInterface{


	private List<CupomDescontoPorDatas> cupomDescontoPorDatas = List.of(
			new CupomDescontoPorDatas(LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 27), 1.0),
			new CupomDescontoPorDatas(LocalDate.of(2025, 6, 16), LocalDate.of(2025, 6, 16), 0.6),
			new CupomDescontoPorDatas(LocalDate.of(2025, 5, 25), LocalDate.of(2025, 5, 25), 0.5)
	);

	@Override
	public void calcularDesconto(Pedido pedido) {
		double maiorPercentual = 0.0;

		for (CupomDescontoPorDatas cupom : cupomDescontoPorDatas) {
			if (cupom.getDataInicio().isBefore(pedido.getDataPedido()) &&
					cupom.getDataFinal().isAfter(pedido.getDataPedido())) {
				if (cupom.getDescontoPercentual() > maiorPercentual) {
					maiorPercentual = cupom.getDescontoPercentual();
				}
			}
		}

		if (maiorPercentual > 0.0) {
			double desconto = maiorPercentual * pedido.getTaxaEntrega();
			pedido.adicionarCupom(new CupomDescontoEntrega("Desconto por período de datas", desconto));
		}
	}

	@Override
	public boolean seAplica(Pedido pedido) {
		return pedido.getDataPedido() != null &&
				cupomDescontoPorDatas.stream().anyMatch(c ->
					c.getDataInicio().isBefore(pedido.getDataPedido()) &&
					c.getDataFinal().isAfter(pedido.getDataPedido()));
	}
}
