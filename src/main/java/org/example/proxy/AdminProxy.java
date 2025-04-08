package org.example.proxy;

public class AdminProxy implements AdminActions {
    private Admin admin;             // instância real do admin
    private String credencial;       // credencial fornecida

    public AdminProxy(String credencial) {
        this.credencial = credencial;
        this.admin = new Admin();    // inicializa o admin real
    }

    private boolean verificarCredenciais() {
        return "admin123".equals(credencial); // verificação simples da senha
    }

    @Override
    public void executarAcaoAdministrativa() {
        if (verificarCredenciais()) {
            admin.executarAcaoAdministrativa(); // acesso permitido
        } else {
            System.out.println("Acesso negado. Credenciais inválidas."); // acesso negado
        }
    }
}