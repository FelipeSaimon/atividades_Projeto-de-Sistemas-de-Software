package Repository;

import dominio.IProdutoRepository;
import dominio.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepositoryEmTXT implements IProdutoRepository {
    private static final String nomeArquivo = "produtos.txt";

    @Override
    public Produto salvar(Produto produto) {

        long novoId = gerarNovoId();

        Produto produtoComId = new Produto(novoId, produto.getNome(), produto.getPrecoUnitario());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            bw.write(produtoComId.getId() + ";" + produtoComId.getNome() + ";" + produtoComId.getPrecoUnitario());

            bw.newLine();
        } catch (IOException e) {

            throw new RuntimeException("Erro ao salvar produto", e);
        }

        return produtoComId;
    }

    @Override
    public void removerPorId(long id) {
        List<Produto> produtos = getTodos();

        produtos.removeIf(produto -> produto.getId() == id);
        reescreverArquivo(produtos);
    }

    @Override
    public Optional<Produto> getPorId(long id) {

        return getTodos().stream().filter(produto -> produto.getId() == id).findFirst();
    }

    @Override
    public List<Produto> getTodos() {

        List<Produto> produtos = new ArrayList<>();

        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            return produtos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Produto produto = new Produto(Long.parseLong(dados[0]), dados[1], Double.parseDouble(dados[2]));

                produtos.add(produto);
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler arquivo", e);
        }

        return produtos;
    }

    @Override
    public List<Produto> buscarPorNomeContendo(String trechoNome) {

        return getTodos().stream().filter(produto -> produto.getNome().toLowerCase().contains(trechoNome.toLowerCase())).toList();
    }

    private long gerarNovoId() {

        List<Produto> produtos = getTodos();

        if (produtos.isEmpty()) {
            return 1;
        }
        return produtos.get(produtos.size() - 1).getId() + 1;
    }

    private void reescreverArquivo(List<Produto> produtos) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (Produto produto : produtos) {
                bw.write(produto.getId() + ";" + produto.getNome() + ";" + produto.getPrecoUnitario());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao reescrever arquivo", e);
        }
    }
}