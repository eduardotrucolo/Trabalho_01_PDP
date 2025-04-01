package org.example.view;


import org.example.decorator.EmbalagemPresente;
import org.example.factory.ProductFactory;
import org.example.model.Pedido;
import org.example.model.PedidoSimples;
import org.example.model.Produto;
import org.example.service.ProdutoService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        ProdutoService produtoService = new ProdutoService();

        Produto p1 = factory.criarProduto("Produto A", 100.00);
        Produto p2 = factory.criarProduto("Produto B", 50.00);

        // Salvar no banco
        produtoService.salvarProduto(p1);
        produtoService.salvarProduto(p2);

        Pedido pedidoSimples = new PedidoSimples(Arrays.asList(p1, p2));

        // Adicionando embalagem para presente com Decorator
        Pedido pedidoComEmbalagem = new EmbalagemPresente(pedidoSimples);

        System.out.println("Descrição: " + pedidoComEmbalagem.getDescricao());
        System.out.println("Total: " + pedidoComEmbalagem.getTotal());
    }
}
