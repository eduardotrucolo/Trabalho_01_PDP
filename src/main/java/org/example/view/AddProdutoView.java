package org.example.view;


import org.example.factory.ProductFactory;
import org.example.model.Produto;
import org.example.service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProdutoView extends JFrame {

    private JTextField nomeField;          // campo de texto para nome
    private JTextField precoField;         // campo de texto para preço
    private JButton adicionarButton;       // botão para adicionar produto

    private ProdutoService produtoService; // serviço para salvar o produto
    private ProductFactory productFactory; // fábrica que cria o produto

    public AddProdutoView() {
        super("Adicionar Produto");

        produtoService = new ProdutoService();     // instancia o serviço
        productFactory = new ProductFactory();     // instancia a factory

        setLayout(new GridLayout(3, 2, 10, 10));   // layout da tela

        add(new JLabel("Nome do Produto:"));       // label + campo nome
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Preço do Produto:"));      // label + campo preço
        precoField = new JTextField();
        add(precoField);

        adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(new AdicionarProdutoAction()); // ação do botão
        add(adicionarButton);

        setSize(300, 150);                         // configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Classe interna para tratar o clique do botão
    private class AdicionarProdutoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            double preco;

            try {
                preco = Double.parseDouble(precoField.getText()); // converte texto para double
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(AddProdutoView.this, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Produto produto = productFactory.criarProduto(nome, preco); // usa Factory para criar o produto
            produtoService.salvarProduto(produto);                      // salva via serviço

            JOptionPane.showMessageDialog(AddProdutoView.this, "Produto adicionado com sucesso!"); // feedback
            nomeField.setText("");     // limpa campos
            precoField.setText("");
        }
    }

    // Inicia a interface gráfica
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddProdutoView::new); // inicia GUI na thread certa
    }
}
