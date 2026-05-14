/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pitagoras;

/**
 *
 * @author gusta
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pitagoras extends JFrame {

    // Campos para o usuário digitar os catetos a e b
    JTextField campoA = new JTextField(10);
    JTextField campoB = new JTextField(10);

    // Label para exibir a hipotenusa (c)
    JLabel labelResultado = new JLabel("Hipotenusa: --");

    public Pitagoras() {
        setTitle("Teorema de Pitágoras");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Campos de entrada dos catetos
        add(new JLabel("Cateto a:")); add(campoA);
        add(new JLabel("Cateto b:")); add(campoB);

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
            double a = Double.parseDouble(campoA.getText());
            double b = Double.parseDouble(campoB.getText());

            // Aplica o teorema: c² = a² + b²
            // Math.sqrt() calcula a raiz quadrada
            double c = Math.sqrt((a * a) + (b * b));

            // Exibe a hipotenusa no JLabel
            labelResultado.setText("Hipotenusa: " + String.format("%.2f", c));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
    }

    public static void main(String[] args) {
        new Pitagoras();
    }
}