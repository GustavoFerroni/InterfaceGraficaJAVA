/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoranotas;

/**
 *
 * @author gustavo 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraNotas extends JFrame {

    //Campos de texto onde o usuário digita cada nota
    JTextField nota1 = new JTextField(10);
    JTextField nota2 = new JTextField(10);
    JTextField nota3 = new JTextField(10);
    JTextField nota4 = new JTextField(10);

    //Label que vai exibir a média calculada
    JLabel labelMedia = new JLabel("Média: --");

    public CalculadoraNotas() {
        setTitle("Calculadora de Notas");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //fecha o programa ao fechar a janela
        setLocationRelativeTo(null); //centraliza na tela
        setLayout(new FlowLayout()); //layout simples em fluxo

        //Adiciona rótulo e campo de cada nota na janela
        add(new JLabel("Nota 1:")); add(nota1);
        add(new JLabel("Nota 2:")); add(nota2);
        add(new JLabel("Nota 3:")); add(nota3);
        add(new JLabel("Nota 4:")); add(nota4);

        //Cria o botão e define a ação ao clicar
        JButton botao = new JButton("Calcular");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular(); // chama o método de cálculo
            }
        });
        add(botao);

        //Adiciona o label de resultado na janela
        add(labelMedia);

        setVisible(true); // exibe a janela
    }

    //Método que lê as notas, calcula a média e atualiza o label
    void calcular() {
        try {
            //Converte o texto dos campos para números decimais
            double n1 = Double.parseDouble(nota1.getText());
            double n2 = Double.parseDouble(nota2.getText());
            double n3 = Double.parseDouble(nota3.getText());
            double n4 = Double.parseDouble(nota4.getText());

            //Calcula a média das 4 notas
            double media = (n1 + n2 + n3 + n4) / 4;

            //Exibe a média no JLabel com 2 casas decimais
            labelMedia.setText("Média: " + String.format("%.2f", media));

        } catch (NumberFormatException ex) {
            //Exibe aviso se o usuário digitar algo que não seja número
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
    }

    //Ponto de entrada do programa
    public static void main(String[] args) {
        new CalculadoraNotas();
    }
}
