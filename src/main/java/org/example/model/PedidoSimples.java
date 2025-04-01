package org.example.model;

import org.example.model.Produto;
import java.util.List;

public class PedidoSimples implements Pedido {
    private List<Produto> produtos;

    public PedidoSimples(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String getDescricao() {
        return "Pedido simples";
    }

    @Override
    public double getTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }
}

