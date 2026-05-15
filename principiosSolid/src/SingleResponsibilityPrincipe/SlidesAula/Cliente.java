package SingleResponsibilityPrincipe.SlidesAula;

public class Cliente {
    private String nomeCliente;
    private String telefoneContato;
    private Endereco endereco;

    public Cliente(String nome, String telefoneContato, Endereco endereco){
        this.nomeCliente = nome;
        this.endereco = endereco;
        this.telefoneContato = telefoneContato;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
