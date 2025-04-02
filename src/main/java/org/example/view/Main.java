package org.example.view;


import org.example.adapter.PayPal;
import org.example.adapter.PayPalAdapter;
import org.example.adapter.PaymentProcessor;
import org.example.decorator.EmbalagemPresente;
import org.example.factory.ProductFactory;
import org.example.model.Pedido;
import org.example.model.PedidoSimples;
import org.example.model.Produto;
import org.example.observer.Cliente;
import org.example.observer.PedidoSubject;
import org.example.proxy.AdminProxy;
import org.example.service.ProdutoService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductFactory factory = new ProductFactory();
        ProdutoService produtoService = new ProdutoService();
        PedidoSubject pedidoSubject = new PedidoSubject();

        System.out.println("Digite seu nome:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);
        pedidoSubject.adicionarObserver(cliente);

        Produto p1 = factory.criarProduto("Produto A", 100.00);
        Produto p2 = factory.criarProduto("Produto B", 50.00);

        // Salvar no banco
        produtoService.salvarProduto(p1);
        produtoService.salvarProduto(p2);

        Pedido pedidoSimples = new PedidoSimples(Arrays.asList(p1, p2));

        // Adicionando embalagem para presente com Decorator
        Pedido pedidoComEmbalagem = new EmbalagemPresente(pedidoSimples);

        System.out.println("Descrição: " + pedidoComEmbalagem.getDescricao());
        System.out.println("Total: " + pedidoComEmbalagem.getTotal());

        // Atualizar status do pedido
        pedidoSubject.setStatus("Em processamento");

        // Escolher meio de pagamento
        System.out.println("Escolha o meio de pagamento (1 - PayPal):");
        int opcaoPagamento = scanner.nextInt();

        PaymentProcessor pagamento = null;
        if (opcaoPagamento == 1) {
            pagamento = new PayPalAdapter(new PayPal());
        }

        if (pagamento != null) {
            pagamento.processarPagamento(pedidoComEmbalagem.getTotal());
        }

        // Simular administração
        scanner.nextLine(); // Limpar buffer
        System.out.println("Digite a credencial de admin:");
        String credencial = scanner.nextLine();
        AdminProxy admin = new AdminProxy(credencial);
        admin.executarAcaoAdministrativa();
    }
}
