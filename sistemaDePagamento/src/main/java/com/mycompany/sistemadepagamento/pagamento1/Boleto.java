
package com.mycompany.sistemadepagamento.pagamento1;

class Boleto implements MetodoPagamento {

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " com boleto.");
    }
}
