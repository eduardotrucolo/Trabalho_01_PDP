package org.example.observer;

public class Cliente implements ClienteObserver {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String status) {
        System.out.println("Cliente " + nome + " foi notificado: Pedido " + status);
    }
}
