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
import javax.swing.*;

public class suma extends JFrame {

    Random random = new Random();

    public suma() {

        /**
         * Creación de la ventana
         *
         */
        setTitle("Suma");
        JLabel sum = new JLabel("¡Vamos praticar las sumas!");
        /**
         * Creación de la ventana
         *
         */
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBotonesDerecha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelBotonesIzquierda = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        /**
         * Creación del boton y cración de la vuelta atrás y botones izquierda y
         * derecha
         *
         */
        JButton botonVolver = new JButton("");
        JButton BotonDerecha = new JButton("");
        JButton BotonIzquierda = new JButton("");

        panelBotones.add(botonVolver);
        panelBotonesDerecha.add(BotonDerecha);
        panelBotonesIzquierda.add(BotonIzquierda);

        /**
         * boton atrás
         *
         */
        botonVolver.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/botonAtras.png")
                )
        );

        
        botonVolver.addActionListener(e -> {
            menuPrincipal ventana = new menuPrincipal();
            ventana.setVisible(true);

            this.dispose();
        });
        /**
         * Boton derecha
         *
         */
        
        BotonDerecha.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaDere.jpg")
                )
        );
       // add(panelBotonesDerecha, BorderLayout.EAST);

        BotonDerecha.addActionListener(e -> {
            suma ventana = new suma();
            ventana.setVisible(true);

            this.dispose();
        });
        add(panelBotonesDerecha, BorderLayout.EAST);
        add(panelBotones, BorderLayout.CENTER);
        add(sum, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);

    }
}