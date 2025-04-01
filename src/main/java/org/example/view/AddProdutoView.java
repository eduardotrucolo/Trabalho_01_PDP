package org.example.view;


import org.example.factory.ProductFactory;
import org.example.model.Produto;
import org.example.service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProdutoView extends JFrame {

    private JTextField nomeField;
    private JTextField precoField;
    private JButton adicionarButton;

    private ProdutoService produtoService;
    private ProductFactory productFactory;

    public AddProdutoView() {
        super("Adicionar Produto");

        produtoService = new ProdutoService();
        productFactory = new ProductFactory();

        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Nome do Produto:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Preço do Produto:"));
        precoField = new JTextField();
        add(precoField);

        adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(new AdicionarProdutoAction());
        add(adicionarButton);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AdicionarProdutoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            double preco;

            try {
                preco = Double.parseDouble(precoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(AddProdutoView.this, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Produto produto = productFactory.criarProduto(nome, preco);
            produtoService.salvarProduto(produto);

            JOptionPane.showMessageDialog(AddProdutoView.this, "Produto adicionado com sucesso!");
            nomeField.setText("");
            precoField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddProdutoView::new);
    }
}
