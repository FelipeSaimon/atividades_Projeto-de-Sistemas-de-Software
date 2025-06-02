package com.mycompany.sistemadepagamento.pagamento2;

public class ChaveCPF implements MetodoPagamentoPix{
    
    @Override
    public void processar(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " com pix.");
    }
}
