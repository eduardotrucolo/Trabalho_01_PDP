package org.example.service;



import org.example.model.Produto;
import org.example.repository.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoService {
    public void salvarProduto(Produto produto) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
