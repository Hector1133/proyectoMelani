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
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class resta extends JFrame {

    private CardLayout cardLayout;
    private JPanel carrusel;
    private int paginaActual = 1;
    private int totalPaginas = 3;

    private JButton BotonDerecha;
    private JButton BotonIzquierda;

    public resta() {
        Random random = new Random();
        /**
         * Creación de la ventana
         *
         */
        setTitle("Resta");
        JLabel rest = new JLabel("¡Vamos praticar las restas!");
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBotonesDerecha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelBotonesIzquierda = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        /**
         *
         * Creación de la ventana
         *
         */
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        /**
         *
         * Creación de los botones
         *
         */
        JButton botonVolver = new JButton("");
        BotonDerecha = new JButton("");
        BotonIzquierda = new JButton("");

        panelBotones.add(botonVolver);
        panelBotonesDerecha.add(BotonDerecha);
        panelBotonesIzquierda.add(BotonIzquierda);

        cardLayout = new CardLayout();
        carrusel = new JPanel(cardLayout);

        // Crear las "páginas" del carrusel
        JPanel pagina1 = crearPagina("Página 1", Color.RED);
        JPanel pagina2 = crearPagina("Página 2", Color.BLUE);
        JPanel pagina3 = crearPagina("Página 3", Color.GREEN);

        carrusel.add(pagina1, "pagina1");
        carrusel.add(pagina2, "pagina2");
        carrusel.add(pagina3, "pagina3");
        /**
         * Boton de atras
         *
         */
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
         */
        BotonDerecha.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaDere.jpg")));

        BotonDerecha.addActionListener(e -> {
            if (paginaActual < 3) {
                paginaActual++;
                cardLayout.show(carrusel, "pagina" + paginaActual);
                actualizarPagina();
            }

        });

        BotonIzquierda.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaIzq.jpg")));

        BotonIzquierda.addActionListener(e -> {
            if (paginaActual > 1) {
                paginaActual--;
                cardLayout.show(carrusel, "pagina" + paginaActual);
                actualizarPagina();

            }

        });

        add(panelBotones, BorderLayout.SOUTH);
        add(panelBotonesDerecha, BorderLayout.EAST);
        add(panelBotonesIzquierda, BorderLayout.WEST);
        add(rest, BorderLayout.NORTH);
        add(carrusel, BorderLayout.CENTER);
    }

    /**
     * Creación metodo para crear las páginas
     *
     */
    private JPanel crearPagina(String texto, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);

        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 30));

        panel.add(label);

        return panel;
    }

    private void actualizarPagina() {
        BotonIzquierda.setVisible(paginaActual > 1);
        BotonDerecha.setVisible(paginaActual < totalPaginas);
    };
}