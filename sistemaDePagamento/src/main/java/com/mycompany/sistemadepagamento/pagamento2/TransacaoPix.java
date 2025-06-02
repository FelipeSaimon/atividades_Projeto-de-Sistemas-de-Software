package com.mycompany.sistemadepagamento.pagamento2;



public class TransacaoPix {
    
    private MetodoPagamentoPix metodo;
    
    public TransacaoPix(MetodoPagamentoPix metodo, double valor){
        this.metodo = metodo;
    }
    
    public void processar(double valor){
        metodo.processar(valor);
    }
}
