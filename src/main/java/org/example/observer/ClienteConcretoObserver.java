package org.example.observer;

import org.example.adapter.PedidoSubject;

public class ClienteConcretoObserver implements ClienteObserver {

    private String nome;

    public ClienteConcretoObserver(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(PedidoSubject pedido) {
        System.out.println("Cliente " + nome + ": Status do pedido atualizado para " + pedido.getStatus());
    }
}
