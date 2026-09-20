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

public class multiplicacion extends JFrame {

    public multiplicacion() {
        Random random = new Random();
        /**
         * Creación de la ventana
         *
         */
        setTitle("Multiplicación");
        JLabel mul = new JLabel("¡Vamos praticar las multiplicaciones!");

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBotonesDerecha = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBotonesIzquierda = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        /**
         * Creación del boton volver, derecha e izquierda
         *
         */
        JButton botonVolver = new JButton("");
        JButton BotonDerecha = new JButton("");
        JButton BotonIzquierda = new JButton("");

        panelBotones.add(botonVolver);
        panelBotonesDerecha.add(BotonDerecha);
        panelBotonesIzquierda.add(BotonIzquierda);

        /**
         * Boton de volver con su imagen correponiente
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
         * Boton derecha con su imagen corresponiente
         *
         */
        BotonDerecha.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaDere.jpg")
                )
        );

        add(panelBotonesDerecha, BorderLayout.EAST);
        BotonDerecha.addActionListener(e -> {
            multiplicacion ventana = new multiplicacion();
            ventana.setVisible(true);

            this.dispose();
        });
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBotonesDerecha, BorderLayout.EAST);
        add(mul, BorderLayout.NORTH);

    }

}
