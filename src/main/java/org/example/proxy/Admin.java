package org.example.proxy;

public class Admin implements AdminActions {
    @Override
    public void executarAcaoAdministrativa() {
        System.out.println("Ação administrativa executada com sucesso."); // ação real
    }
}