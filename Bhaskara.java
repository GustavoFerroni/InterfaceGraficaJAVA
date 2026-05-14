/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bhaskara;

/**
 *
 * @author gusta
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bhaskara extends JFrame {

    // Campos para o usuário digitar os valores de a, b e c
    JTextField campoA = new JTextField(10);
    JTextField campoB = new JTextField(10);
    JTextField campoC = new JTextField(10);

    // Labels para exibir os resultados x' e x''
    JLabel labelX1 = new JLabel("x'  --");
    JLabel labelX2 = new JLabel("x'' --");

    public Bhaskara() {
        setTitle("Fórmula de Bhaskara");
        setSize(320, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Título e fórmula
        add(new JLabel("Fórmula de Bhaskara"));
        add(new JLabel("ax² + bx + c = 0"));

        // Campos de entrada
        add(new JLabel("Valor de a")); add(campoA);
        add(new JLabel("Valor de b")); add(campoB);
        add(new JLabel("Valor de c")); add(campoC);

        // Botão calcular
        JButton botao = new JButton("Calcular");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        add(botao);

        // Labels de resultado
        add(labelX1);
        add(labelX2);

        setVisible(true);
    }

    void calcular() {
        try {
            double a = Double.parseDouble(campoA.getText());
            double b = Double.parseDouble(campoB.getText());
            double c = Double.parseDouble(campoC.getText());

            // Calcula o discriminante (delta)
            double delta = (b * b) - (4 * a * c);

            // Verifica se há raízes reais
            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "Delta negativo: sem raízes reais!");
                return;
            }

            // Aplica a fórmula de Bhaskara
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            // Exibe os resultados nos labels
            labelX1.setText("x'  " + x1);
            labelX2.setText("x'' " + x2);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
    }

    public static void main(String[] args) {
        new Bhaskara();
    }
}