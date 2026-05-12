package dominio;

import java.util.List;
import java.util.Optional;

public interface IProdutoRepository {
    Produto salvar(Produto produto);
    void removerPorId(long id);
    Optional<Produto> getPorId(long id);
    List<Produto> getTodos();
    List<Produto> buscarPorNomeContendo(String trechoNome);
}
