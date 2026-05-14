/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversortemperatura;

/**
 *
 * @author gusta
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorTemperatura extends JFrame {

    // Campo onde o usuário digita a temperatura em Celsius
    JTextField campoCelsius = new JTextField(10);

    // Labels que exibem os resultados
    JLabel labelFahrenheit = new JLabel("--");
    JLabel labelKelvin = new JLabel("--");

    public ConversorTemperatura() {
        setTitle("Conversor de Temperatura");
        setSize(320, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Título
        add(new JLabel("Conversor de Temperatura"));

        // Campo de entrada
        add(new JLabel("Graus Celsius:"));
        add(campoCelsius);

        // Labels de resultado
        add(new JLabel("Graus Fahrenheit:"));
        add(labelFahrenheit);

        add(new JLabel("Graus Kelvin:"));
        add(labelKelvin);

        // Botão converter
        JButton botao = new JButton("Converte");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                converter();
            }
        });
        add(botao);

        setVisible(true);
    }

    void converter() {
        try {
            double celsius = Double.parseDouble(campoCelsius.getText());

            // Fórmula: Fahrenheit = (Celsius × 9/5) + 32
            double fahrenheit = (celsius * 9.0 / 5.0) + 32;

            // Fórmula: Kelvin = Celsius + 273,15
            double kelvin = celsius + 273.15;

            // Exibe os resultados nos labels
            labelFahrenheit.setText(String.format("%.2f", fahrenheit));
            labelKelvin.setText(String.format("%.2f", kelvin));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
    }

    public static void main(String[] args) {
        new ConversorTemperatura();
    }
}
