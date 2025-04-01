package org.example.observer;

import org.example.adapter.PedidoSubject;

public interface ClienteObserver {
    void atualizar(PedidoSubject pedido);
}
