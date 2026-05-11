import dominio.IProdutoRepository;
import dominio.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProdutoRepositoryEmMemoria implements IProdutoRepository {

    private final List<Produto> elementos;

    public ProdutoRepositoryEmMemoria() {
        this.elementos = new ArrayList<Produto>();
        this.elementos.add(new Produto(1L, "Caderno Universitário 96 Folhas", 18.90));
        this.elementos.add(new Produto(2L, "Lápis Grafite HB Nº2", 1.50));
        this.elementos.add(new Produto(3L, "Borracha Branca Escolar", 2.20));
        this.elementos.add(new Produto(4L, "Caneta Esferográfica Azul", 3.10));
        this.elementos.add(new Produto(5L, "Marcador de Texto Amarelo", 6.40));
    }


    @Override
    public Produto salvar(Produto produto) {
        validarProduto(produto);

        for (Produto produtoExistente : this.elementos) {
            if (produtoExistente.getId() == produto.getId()) {
                produtoExistente.setNome(produto.getNome());
                produtoExistente.setPrecoUnitario(produto.getPrecoUnitario());
                return produtoExistente;
            }
        }

        this.elementos.add(produto);
        return produto;
    }

    @Override
    public void removerPorId(long id) {
        validarId(id);

        Produto produtoParaRemover = null;

        for (Produto produto : this.elementos) {
            if (produto.getId() == id) {
                produtoParaRemover = produto;
                break;
            }
        }

        if (produtoParaRemover == null) {
            throw new RuntimeException("Não foi possível remover o produto, pois o id informado não foi encontrado: " + id + ".");
        }

        this.elementos.remove(produtoParaRemover);
    }

    @Override
    public Optional<Produto> getPorId(long id) {
        validarId(id);

        for (Produto produto : this.elementos) {
            if (produto.getId() == id) {
                return Optional.of(produto);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Produto> getTodos() {
        return Collections.unmodifiableList(this.elementos);
    }

    @Override
    public List<Produto> buscarPorNomeContendo(String trechoNome) {
        validarTrechoNome(trechoNome);

        String filtro = trechoNome.trim().toLowerCase();
        List<Produto> resultado = new ArrayList<Produto>();

        for (Produto produto : this.elementos) {
            String nomeNormalizado = produto.getNome().toLowerCase();

            if (nomeNormalizado.contains(filtro)) {
                resultado.add(produto);
            }
        }

        return Collections.unmodifiableList(resultado);
    }

    private void validarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto deve ser informado.");
        }
    }

    private void validarId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O id do produto deve ser maior que zero.");
        }
    }

    private void validarTrechoNome(String trechoNome) {
        if (trechoNome == null || trechoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O trecho do nome para busca deve ser informado.");
        }
    }
}
