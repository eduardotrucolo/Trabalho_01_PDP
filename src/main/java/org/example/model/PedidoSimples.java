package org.example.model;

import org.example.model.Produto;
import java.util.List;

public class PedidoSimples implements Pedido {
    private List<Produto> produtos; // lista de produtos do pedido

    public PedidoSimples(List<Produto> produtos) {
        this.produtos = produtos; // injeta os produtos no pedido
    }

    @Override
    public String getDescricao() {
        return "Pedido simples"; // descrição padrão
    }

    @Override
    public double getTotal() {
        // soma os preços de todos os produtos
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}

