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
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class division extends JFrame {
    Random random = new Random();

    public division() {
        /**
         * Creación de la ventana
         *
         */
        setTitle("División");
        JLabel div = new JLabel("¡Vamos praticar las divisiones!");
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBotonDerecha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelBotonIzquierda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        /**
         * Creación de la ventana
         *
         */
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        /**
         * Creación del boton y cración de la vuelta atrás
         *
         */
        JButton botonVolver = new JButton("");
        JButton BotonDerecha = new JButton("");
        JButton BotonIzquierda = new JButton("");

        panelBotones.add(botonVolver);
        panelBotonDerecha.add(BotonDerecha);
        panelBotonIzquierda.add(BotonIzquierda);

        botonVolver.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/botonAtras.png")));

        botonVolver.addActionListener(e -> {
            menuPrincipal ventana = new menuPrincipal();
            ventana.setVisible(true);
            this.dispose();
        });
        /**
         * Boton derecha
         *
         *
         */
        BotonDerecha.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaDere.jpg")));

        BotonDerecha.addActionListener(e -> {
            division ventana = new division();
            ventana.setVisible(true);
            this.dispose();
        });
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBotonDerecha, BorderLayout.EAST);
        add(div, BorderLayout.NORTH);
    }
}