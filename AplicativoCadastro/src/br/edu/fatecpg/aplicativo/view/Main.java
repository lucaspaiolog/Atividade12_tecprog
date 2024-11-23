package br.edu.fatecpg.aplicativo.view;

import br.edu.fatecpg.aplicativo.model.Cliente;
import br.edu.fatecpg.aplicativo.model.EmailInvalido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        JFrame frame = new JFrame("Cadastro de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel labelNome = new JLabel("Nome do Cliente:");
        JTextField fieldNome = new JTextField();

        JLabel labelIdade = new JLabel("Idade:");
        JTextField fieldIdade = new JTextField();

        JLabel labelEmail = new JLabel("E-mail:");
        JTextField fieldEmail = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");

        frame.add(labelNome);
        frame.add(fieldNome);
        frame.add(labelIdade);
        frame.add(fieldIdade);
        frame.add(labelEmail);
        frame.add(fieldEmail);
        frame.add(new JLabel());
        frame.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = fieldNome.getText().trim();
                    if (nome.isEmpty()) {
                        throw new IllegalArgumentException("O nome não pode estar vazio.");
                    }

                    String idadeTexto = fieldIdade.getText().trim();
                    int idade;
                    try {
                        idade = Integer.parseInt(idadeTexto);
                    } catch (NumberFormatException ex) {
                        throw new IllegalArgumentException("A idade deve ser um número inteiro.");
                    }

                    String email = fieldEmail.getText().trim();
                    if (!email.contains("@")) {
                        throw new EmailInvalido("O e-mail informado é inválido.");
                    }

                    Cliente cliente = new Cliente(nome, idade, email);
                    JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso:\n"
                            + "Nome: " + cliente.getNome() + "\nIdade: " + cliente.getIdade() + "\nE-mail: " + cliente.getEmail(),
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } catch (EmailInvalido ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
