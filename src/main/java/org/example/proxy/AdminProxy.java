package org.example.proxy;

public class AdminProxy implements AdminActions {
    private Admin admin;
    private String credencial;

    public AdminProxy(String credencial) {
        this.credencial = credencial;
        this.admin = new Admin();
    }

    private boolean verificarCredenciais() {
        return "admin123".equals(credencial);
    }

    @Override
    public void executarAcaoAdministrativa() {
        if (verificarCredenciais()) {
            admin.executarAcaoAdministrativa();
        } else {
            System.out.println("Acesso negado. Credenciais inválidas.");
        }
    }
}