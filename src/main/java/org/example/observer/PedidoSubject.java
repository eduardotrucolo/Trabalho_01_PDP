package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoSubject {
    private List<ClienteObserver> observers = new ArrayList<>();
    private String status;

    public void adicionarObserver(ClienteObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(ClienteObserver observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notificarObservers();
    }

    private void notificarObservers() {
        for (ClienteObserver observer : observers) {
            observer.atualizar(status);
        }
    }
}
