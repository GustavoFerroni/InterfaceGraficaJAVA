/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.imc;

/**
 *
 * @author gusta
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IMC extends JFrame {

    // Campos para o usuário digitar peso e altura
    JTextField campoPeso = new JTextField(10);
    JTextField campoAltura = new JTextField(10);

    // Label para exibir o resultado do IMC
    JLabel labelResultado = new JLabel("IMC: --");

    public IMC() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Campos de entrada
        add(new JLabel("Peso (kg):")); add(campoPeso);
        add(new JLabel("Altura (m):")); add(campoAltura);

        // Botão calcular
        JButton botao = new JButton("Calcular");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        add(botao);

        // Label do resultado
        add(labelResultado);

        setVisible(true);
    }

    void calcular() {
        try {
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText());

            // Fórmula do IMC: peso dividido pela altura ao quadrado
            double imc = peso / (altura * altura);

            // Verifica a classificação conforme o valor do IMC
            String classificacao;
            if (imc < 18) {
                classificacao = "Abaixo do Peso";
            } else if (imc <= 24.99) {
                classificacao = "Peso Ideal";
            } else {
                classificacao = "Acima do Peso Ideal";
            }

            // Exibe o IMC e a classificação no label
            labelResultado.setText("IMC: " + String.format("%.2f", imc) + " - " + classificacao);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
    }

    public static void main(String[] args) {
        new IMC();
    }
}