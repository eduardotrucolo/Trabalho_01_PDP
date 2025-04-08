package org.example.adapter;

public class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal; // referência ao objeto PayPal

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal; // injeta o objeto PayPal
    }

    @Override
    public void processarPagamento(double valor) {
        payPal.efetuarPagamento(valor); // adapta a chamada para o metodo do PayPal
    }
}
