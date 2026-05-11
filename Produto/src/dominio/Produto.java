package dominio;

public class Produto {
    private long id;
    private String nome;
    private double precoUnitario;

    public Produto(long id, String nome, double precoUnitario) {
        this.setId(id);
        this.setNome(nome);
        this.setPrecoUnitario(precoUnitario);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id do produto deve ser maior que zero.");
        }

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto deve ser informado.");
        }

        this.nome = nome.trim();
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario < 0.0) {
            throw new IllegalArgumentException("O preço unitário do produto não pode ser negativo.");
        }

        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "dominio.Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
