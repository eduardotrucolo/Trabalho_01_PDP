package org.example.factory;


import org.example.model.Produto;

public class ProductFactory {
    public Produto criarProduto(String nome, double preco) {
        return new Produto(nome, preco);
    }
}

