package service;

import dominio.IProdutoRepository;
import dominio.Produto;

import java.util.List;
import java.util.Optional;

public class ProdutoConsultaService {

    private final IProdutoRepository produtoRepository;

    public ProdutoConsultaService(IProdutoRepository produtoRepository) {
        if (produtoRepository == null) {
            throw new IllegalArgumentException("O repositório de produtos deve ser informado.");
        }

        this.produtoRepository = produtoRepository;
    }

    public Produto obterDetalhesDeProduto(long id) {
        Optional<Produto> produtoEncontrado = this.produtoRepository.getPorId(id);

        if (produtoEncontrado.isEmpty()) {
            throw new RuntimeException("Produto não encontrado para o id informado: " + id + ".");
        }

        return produtoEncontrado.get();
    }

    public List<Produto> pesquisarProdutosPorNome(String termo) {
        return this.produtoRepository.buscarPorNomeContendo(termo);
    }

    public double calcularPrecoMedioDosResultados(String termo) {
        List<Produto> encontrados = this.produtoRepository.buscarPorNomeContendo(termo);

        if (encontrados.isEmpty()) {
            throw new RuntimeException("Não foi possível calcular o preço médio, pois nenhum produto foi encontrado para o termo informado: " + termo + ".");
        }

        double soma = 0.0;

        for (Produto produto : encontrados) {
            soma = soma + produto.getPrecoUnitario();
        }

        return soma / encontrados.size();
    }
}
