package org.example.decorator;


import org.example.model.Pedido;

public abstract class PedidoDecorator implements Pedido {
    protected Pedido pedido;

    public PedidoDecorator(Pedido pedido) {
        this.pedido = pedido;
    }
}

