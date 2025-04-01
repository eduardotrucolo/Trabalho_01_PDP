package org.example.adapter;

import org.example.observer.ClienteObserver;

import java.util.ArrayList;
import java.util.List;

public class PedidoSubject {
    private String status;
    private List<ClienteObserver> observers = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notificarTodosObservers();
    }

    public void adicionarObserver(ClienteObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(ClienteObserver observer) {
        observers.remove(observer);
    }

    private void notificarTodosObservers() {
        for (ClienteObserver observer : observers) {
            observer.atualizar(this);
        }
    }
}
