package SingleResponsibilityPrincipe.Youtube;


// SOLID: O Que Ninguém Te Explicou Sobre Responsabilidade Única!
// Renato Augusto
public class Pedido {
    private String uuid;
    private Double amount;

    public Pedido(String id, Double amount){
        this.amount = amount;
        this.uuid = id;
    }

    public String getUuid() {
        return uuid;
    }

    public Double getAmount() {
        return amount;
    }
}
