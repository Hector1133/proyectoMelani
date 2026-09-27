/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 */
package com.mycompany.juego_mates;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Representa la interfaz gráfica y la lógica para el juego de restar.
 * Utiliza una estructura de carrusel (CardLayout) para mostrar diferentes
 * páginas con ejercicios matemáticos de restas por niveles.
 *
 * @author Héctor Ruiz Rivera
 * @version 1.0
 */
public class resta extends JFrame {

    /** Administrador de diseño para controlar el cambio de páginas. */
    private CardLayout cardLayout;

    /** Panel contenedor que almacena las diferentes páginas del juego. */
    private JPanel carrusel;

    /** Índice que rastrea la página actual. */
    private int paginaActual = 1;

    /** Cantidad total de páginas disponibles. */
    private int totalPaginas = 3;

    /** Botón para avanzar a la siguiente página. */
    private JButton BotonDerecha;

    /** Botón para retroceder a la página anterior. */
    private JButton BotonIzquierda;

    /**
     * Constructor de la clase resta.
     * Configura la ventana, los botones y el carrusel de páginas.
     */
    public resta() {

        // Configuración y creación de la ventana
        setTitle("Resta");

        JLabel rest = new JLabel("¡Vamos a practicar las restas!");

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panelBotonesDerecha = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel panelBotonesIzquierda = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de los botones de navegación
        JButton botonVolver = new JButton("");
        BotonDerecha = new JButton("");
        BotonIzquierda = new JButton("");

        panelBotones.add(botonVolver);
        panelBotonesDerecha.add(BotonDerecha);
        panelBotonesIzquierda.add(BotonIzquierda);

        // Configuración del CardLayout
        cardLayout = new CardLayout();
        carrusel = new JPanel(cardLayout);

        // Crear las páginas del carrusel
        JPanel pagina1 = crearPagina("Página 1", Color.RED);

        JTextArea definicion = new JTextArea(
                "La resta (o sustracción) es una operación matemática "
                        + "que consiste en quitar o sacar una cantidad de otra "
                        + "para saber cuántos elementos quedan.");

        definicion.setPreferredSize(new Dimension(550, 180));
        definicion.setFont(new Font("Arial", Font.PLAIN, 22));

        definicion.setLineWrap(true);
        definicion.setWrapStyleWord(true);

        definicion.setEditable(false);
        definicion.setFocusable(false);

        definicion.setOpaque(false);

        definicion.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pagina1.add(definicion);

        pagina1.add(definicion);

        JPanel pagina2 = crearPartesResta();
        JPanel pagina3 = crearPagina("Página 3", Color.GREEN);
        JPanel pagina = new JPanel(new BorderLayout());

        // Añadir las páginas al carrusel
        carrusel.add(pagina1, "pagina1");
        carrusel.add(pagina2, "pagina2");
        carrusel.add(pagina3, "pagina3");

        // Configuración del botón para volver al menú principal
        botonVolver.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/botonAtras.png")));

        botonVolver.addActionListener(e -> {
            menuPrincipal ventana = new menuPrincipal();
            ventana.setVisible(true);
            this.dispose();
        });

        // Configuración del botón para ir a la derecha
        BotonDerecha.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaDere.jpg")));

        BotonDerecha.addActionListener(e -> {
            if (paginaActual < totalPaginas) {
                paginaActual++;
                cardLayout.show(
                        carrusel,
                        "pagina" + paginaActual);
                actualizarPagina();
            }
        });

        // Configuración del botón para ir a la izquierda
        BotonIzquierda.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaIzq.jpg")));

        BotonIzquierda.addActionListener(e -> {
            if (paginaActual > 1) {
                paginaActual--;
                cardLayout.show(
                        carrusel,
                        "pagina" + paginaActual);
                actualizarPagina();
            }
        });

        // Inicializa la visibilidad de las flechas
        actualizarPagina();

        // Añadir los paneles y componentes a la ventana
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBotonesDerecha, BorderLayout.EAST);
        add(panelBotonesIzquierda, BorderLayout.WEST);
        add(rest, BorderLayout.NORTH);
        add(carrusel, BorderLayout.CENTER);
    }

    private JPanel crearPartesResta() {
        JPanel pagina = new JPanel(new BorderLayout());
        JPanel operacion = new JPanel(new FlowLayout());
        JLabel explicacion = new JLabel("Pulsa un botón");
        JButton Sumando1 = new JButton("30");
        JButton Sumando2 = new JButton("25");
        JButton operador = new JButton("-");
        JButton igualdad = new JButton("=");
        JButton resultado = new JButton("5");

        Sumando1.addActionListener(e -> {
            explicacion.setText("Este es el Minuendo");
        });

        operador.addActionListener(e -> {
            explicacion.setText("Este es el signo resta");

        });

        Sumando2.addActionListener(e -> {
            explicacion.setText("Este es el sustraendo");

        });
        igualdad.addActionListener(e -> {
            explicacion.setText("Este es el igual o igualdad");

        });
        resultado.addActionListener(e -> {
            explicacion.setText("Este es la diferencia");

        });

        pagina.add(operacion, BorderLayout.CENTER);
        pagina.add(explicacion, BorderLayout.SOUTH);
        operacion.add(Sumando1);
        operacion.add(operador);
        operacion.add(Sumando2);

        operacion.add(igualdad);
        operacion.add(resultado);

        return pagina;

    }

    /**
     * Método auxiliar para construir dinámicamente los paneles
     * que servirán como páginas en el juego.
     *
     * @param texto título o contenido textual de la página
     * @param color color de fondo del panel
     * @return panel configurado
     */
    private JPanel crearPagina(String texto, Color color) {

        JPanel panel = new JPanel();
        panel.setBackground(color);

        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 30));

        panel.add(label);

        return panel;
    }

    /**
     * Actualiza la visibilidad de los botones de navegación
     * dependiendo de la página actual.
     */
    private void actualizarPagina() {

        BotonIzquierda.setVisible(paginaActual > 1);
        BotonDerecha.setVisible(paginaActual < totalPaginas);
    }
}