package org.example.decorator;


import org.example.model.Pedido;

public abstract class PedidoDecorator implements Pedido {
    protected Pedido pedido; // referência ao pedido original

    public PedidoDecorator(Pedido pedido) {
        this.pedido = pedido; // injeta o pedido a ser decorado
    }
}

