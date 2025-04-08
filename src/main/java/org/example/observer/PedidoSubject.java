package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoSubject {
    private List<ClienteObserver> observers = new ArrayList<>(); // lista de observadores
    private String status; // status do pedido

    public void adicionarObserver(ClienteObserver observer) {
        observers.add(observer); // adiciona cliente na lista
    }

    public void removerObserver(ClienteObserver observer) {
        observers.remove(observer); // remove cliente da lista
    }

    public void setStatus(String status) {
        this.status = status;      // atualiza o status do pedido
        notificarObservers();      // notifica todos os clientes
    }

    private void notificarObservers() {
        for (ClienteObserver observer : observers) {
            observer.atualizar(status); // chama o metodo de atualização de cada cliente
        }
    }
}
