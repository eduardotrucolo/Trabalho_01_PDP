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

        // Factory e service para produtos
        ProductFactory factory = new ProductFactory();
        ProdutoService produtoService = new ProdutoService();

        // Subject do Observer (pedido)
        PedidoSubject pedidoSubject = new PedidoSubject();

        System.out.println("Digite seu nome:");
        String nomeCliente = scanner.nextLine();

        // Criação do observador (cliente)
        Cliente cliente = new Cliente(nomeCliente);
        pedidoSubject.adicionarObserver(cliente); // adiciona cliente como observador

        // Criação de produtos usando Factory
        Produto p1 = factory.criarProduto("Produto h", 100.00);
        Produto p2 = factory.criarProduto("Produto k", 50.00);

        // Simula persistência dos produtos
        produtoService.salvarProduto(p1);
        produtoService.salvarProduto(p2);

        // Criação de um pedido simples (com os dois produtos)
        Pedido pedidoSimples = new PedidoSimples(Arrays.asList(p1, p2));

        // Aplicação do Decorator: adiciona embalagem ao pedido
        Pedido pedidoComEmbalagem = new EmbalagemPresente(pedidoSimples);

        // Exibe a descrição e o valor total (com o adicional da embalagem)
        System.out.println("Descrição: " + pedidoComEmbalagem.getDescricao());
        System.out.println("Total: " + pedidoComEmbalagem.getTotal());

        // Observer: altera status e notifica o cliente
        pedidoSubject.setStatus("Em processamento");

        // Escolha do meio de pagamento
        System.out.println("Escolha o meio de pagamento (1 - PayPal):");
        int opcaoPagamento = scanner.nextInt();

        PaymentProcessor pagamento = null;
        if (opcaoPagamento == 1) {
            // Adapter: adaptando PayPal para a interface PaymentProcessor
            pagamento = new PayPalAdapter(new PayPal());
        }

        // Processamento do pagamento
        if (pagamento != null) {
            pagamento.processarPagamento(pedidoComEmbalagem.getTotal());
        }

        // Proxy: controla acesso a ações administrativas
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.println("Digite a credencial de admin:");
        String credencial = scanner.nextLine();

        AdminProxy admin = new AdminProxy(credencial);
        admin.executarAcaoAdministrativa(); // executa a ação se credencial for válida
    }
}
