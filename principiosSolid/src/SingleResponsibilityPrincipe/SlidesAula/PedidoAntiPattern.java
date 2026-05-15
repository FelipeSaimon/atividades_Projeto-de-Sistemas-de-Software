package SingleResponsibilityPrincipe.SlidesAula;

public class PedidoAntiPattern {
    private String nomeCliente;
    private String enderecoEntrega;
    private double valorTotal;
    private String status;

    public PedidoAntiPattern(String nomeCliente, String enderecoEntrega, double valorTotal, String status){
        this.nomeCliente = nomeCliente;
        this.enderecoEntrega = enderecoEntrega;
        this.valorTotal = valorTotal;
        this.status = "pendente";
    }

    public double calcularTaxaEntrega(){
        return 10.00;
    }

    public void atualizarParaEmTransito(){
        this.status = "Em transito";
    }

    public void atualizarParaEntregue(){
        this.status = "entregue";
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PedidoAntiPattern{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", enderecoEntrega='" + enderecoEntrega + '\'' +
                ", valorTotal=" + valorTotal +
                ", status='" + status + '\'' +
                '}';
    }
}
