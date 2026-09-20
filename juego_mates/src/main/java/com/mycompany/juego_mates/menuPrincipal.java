/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juego_mates;

/**
 *
 * @author Héctor Ruiz Rivera
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.*;

public class menuPrincipal extends JFrame {

    public menuPrincipal() {
        /**
         * Creación de la ventana
         *
         */
        setTitle("Menu principal");
        JLabel menu = new JLabel("¡Bienvenida jugadora!¡¡Vamos a jugar con las mates!!"
                + "¿Ha que quieres jugar?");

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        /**
         * Creación de los botones
         *
         */
        JButton botonSumar = new JButton("Sumar");
        JButton botonRestar = new JButton("Restar");
        JButton botonDividir = new JButton("Dividir");
        JButton botonMultiplicar = new JButton("Multiplicar");
        add(panelBotones, BorderLayout.CENTER);

        panelBotones.add(botonSumar);
        panelBotones.add(botonRestar);
        panelBotones.add(botonDividir);
        panelBotones.add(botonMultiplicar);

        /**
         * Llamadas a las ventanas de las otras clases
         *
         */
        botonSumar.addActionListener(e -> {
            suma ventana = new suma();
            ventana.setVisible(true);
            this.dispose();
        });
        botonRestar.addActionListener(e -> {
            resta ventana = new resta();
            ventana.setVisible(true);
            this.dispose();
        }
        );
        botonDividir.addActionListener(e -> {
            division ventana = new division();
            ventana.setVisible(true);
            this.dispose();
        }
        );
        botonMultiplicar.addActionListener(e -> {
            multiplicacion ventana = new multiplicacion();
            ventana.setVisible(true);
            this.dispose();
        }
        );
        add(menu, BorderLayout.NORTH);

    }

}
