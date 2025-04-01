package org.example.decorator;



import org.example.model.Pedido;

public class EmbalagemPresente extends PedidoDecorator {
    public EmbalagemPresente(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String getDescricao() {
        return pedido.getDescricao() + " + Embalagem para presente";
    }

    @Override
    public double getTotal() {
        return pedido.getTotal() + 10.00; // valor adicional fixo
    }
}

