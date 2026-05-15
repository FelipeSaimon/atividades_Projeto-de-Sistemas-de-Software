package SingleResponsibilityPrincipe.SlidesAula;

public class PedidoComSRP {
    private Cliente cliente;
    private double valorTotal;
    private String status;

    public PedidoComSRP(Cliente cliente, double valorTotal, String status) {
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = "pendente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        return "PedidoComSRP{" + "cliente=" + cliente + ", valorTotal=" + valorTotal + ", status='" + status + '\'' + '}';
    }
}
