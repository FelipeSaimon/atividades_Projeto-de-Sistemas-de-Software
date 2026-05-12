package Repository;

import Connection.DBConnection;
import dominio.IProdutoRepository;
import dominio.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepositoryEmSQLite implements IProdutoRepository {
    public static void createTable() {
        String sql =
                "CREATE TABLE IF NOT EXISTS produtos (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nome TEXT NOT NULL, " +
                        "precoUnitario REAL NOT NULL" +
                        ")";
        try (
                var connection = DBConnection.connect();
                var statement = connection.createStatement()
        ) {
            statement.execute(sql);
            System.out.println("Tabela produtos criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    @Override
    public Produto salvar(Produto produto) {
        String sql =
                "INSERT INTO produtos(nome, precoUnitario) VALUES(?, ?)";
        try (
                var connection = DBConnection.connect();
                var prepStatement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            prepStatement.setString(1, produto.getNome());
            prepStatement.setDouble(2, produto.getPrecoUnitario());
            int linhasAfetadas = prepStatement.executeUpdate();
            if (linhasAfetadas > 0) {
                try (ResultSet generatedKeys =
                             prepStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        produto.setId(generatedKeys.getLong(1));
                    }
                }
            }
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto", e);
        }
    }

    @Override
    public void removerPorId(long id) {
        String sqlRemove =
                "DELETE FROM produtos WHERE id = ?";
        try (
                var connection = DBConnection.connect();
                var pstmt = connection.prepareStatement(sqlRemove)
        ) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover produto", e);
        }
    }

    @Override
    public Optional<Produto> getPorId(long id) {
        String sql =
                "SELECT * FROM produtos WHERE id = ?";
        try (
                var connection = DBConnection.connect();
                var pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getDouble("precoUnitario"));
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                return Optional.of(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Produto> getTodos() {
        String sql =
                "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();
        try (
                var connection = DBConnection.connect();
                var pstmt = connection.prepareStatement(sql)
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getDouble("precoUnitario")
                );
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }
        return produtos;
    }

    @Override
    public List<Produto> buscarPorNomeContendo(String trechoNome) {
        String sql =
                "SELECT * FROM produtos WHERE nome LIKE ?";
        List<Produto> produtos = new ArrayList<>();
        try (
                var connection = DBConnection.connect();
                var pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, "%" + trechoNome + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getDouble("precoUnitario")
                );
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produtos por nome",
                    e);
        }
        return produtos;
    }
}