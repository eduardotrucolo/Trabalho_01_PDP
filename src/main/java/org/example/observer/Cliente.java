package org.example.observer;

public class Cliente implements ClienteObserver {
    private String nome; // nome do cliente

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String status) {
        // exibe notificação do status do pedido
        System.out.println("Cliente " + nome + " foi notificado: Pedido " + status);
    }
}