/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.triangulo;

/**
 *
 * @author gusta
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Triangulo extends JFrame {

    // Campos para o usuário digitar os 3 lados
    JTextField lado1 = new JTextField(10);
    JTextField lado2 = new JTextField(10);
    JTextField lado3 = new JTextField(10);

    // Label para exibir o tipo do triângulo
    JLabel labelResultado = new JLabel("");

    public Triangulo() {
        setTitle("Tipo de Triângulo");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Campos de entrada
        add(new JLabel("Lado 1:")); add(lado1);
        add(new JLabel("Lado 2:")); add(lado2);
        add(new JLabel("Lado 3:")); add(lado3);

        // Botão verificar
        JButton botao = new JButton("Verificar Tipo");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificar();
            }
        });
        add(botao);

        // Label do resultado
        add(labelResultado);

        setVisible(true);
    }

    void verificar() {
        try {
            double l1 = Double.parseDouble(lado1.getText());
            double l2 = Double.parseDouble(lado2.getText());
            double l3 = Double.parseDouble(lado3.getText());

            // Verifica o tipo conforme a igualdade dos lados
            if (l1 == l2 && l2 == l3) {
                labelResultado.setText("Triângulo Equilátero");
            } else if (l1 == l2 || l1 == l3 || l2 == l3) {
                labelResultado.setText("Triângulo Isósceles");
            } else {
                labelResultado.setText("Triângulo Escaleno");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
    }

    public static void main(String[] args) {
        new Triangulo();
    }
}