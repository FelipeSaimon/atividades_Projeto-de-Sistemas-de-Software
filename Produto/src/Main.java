//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Repository.ProdutoRepositoryEmMemoria;
import dominio.IProdutoRepository;
import dominio.Produto;
import service.ProdutoConsultaService;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        try {
            IProdutoRepository produtoRepository = new ProdutoRepositoryEmMemoria();
            ProdutoConsultaService produtoConsultaService = new ProdutoConsultaService(produtoRepository);

            Produto produtoEncontrado = produtoConsultaService.obterDetalhesDeProduto(1L);
            System.out.println(produtoEncontrado);

            List<Produto> produtosEncontrados = produtoConsultaService.pesquisarProdutosPorNome("caneta");
            for (Produto produto : produtosEncontrados) {
                System.out.println(produto);
            }

            double precoMedio = produtoConsultaService.calcularPrecoMedioDosResultados("a");
            System.out.println("Preço médio: " + precoMedio);

            produtoRepository.removerPorId(3L);
            System.out.println("Produto removido com sucesso.");

            Produto produtoRemovido = produtoConsultaService.obterDetalhesDeProduto(3L);
            System.out.println(produtoRemovido);
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
        }
    }
}
