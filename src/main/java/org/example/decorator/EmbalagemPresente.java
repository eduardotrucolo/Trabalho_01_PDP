package org.example.decorator;



import org.example.model.Pedido;

public class EmbalagemPresente extends PedidoDecorator {
    public EmbalagemPresente(Pedido pedido) {
        super(pedido); // passa o pedido original
    }

    @Override
    public String getDescricao() {
        return pedido.getDescricao() + " + Embalagem para presente"; // adiciona descrição extra
    }

    @Override
    public double getTotal() {
        return pedido.getTotal() + 10.00; // adiciona valor extra fixo
    }
}

