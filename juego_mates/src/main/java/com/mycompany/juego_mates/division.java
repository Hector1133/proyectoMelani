
package com.mycompany.juego_mates;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Representa la interfaz gráfica y la lógica para el juego de divisiones.
 * Utiliza una estructura de carrusel (CardLayout) para mostrar diferentes
 * páginas con ejercicios matemáticos de divisiones.
 *
 * @author Héctor Ruiz Rivera
 * @version 1.0
 */
public class division extends JFrame {

    /** Administrador de diseño para controlar el cambio de páginas. */
    private CardLayout cardLayout;

    /** Panel contenedor que almacena las diferentes páginas del juego. */
    private JPanel carrusel;

    /** Índice de la página actual. */
    private int paginaActual = 1;

    /** Cantidad total de páginas disponibles. */
    private int totalPaginas = 3;

    /** Botón para avanzar a la siguiente página. */
    private JButton BotonDerecha;

    /** Botón para retroceder a la página anterior. */
    private JButton BotonIzquierda;

    /** Generador de números aleatorios. */
    Random random = new Random();

    /**
     * Constructor de la ventana de divisiones.
     */
    public division() {

        // Configuración de la ventana
        setTitle("División");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Título
        JLabel rest = new JLabel("¡Vamos a practicar las Divisiones!");

        // Paneles para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBotonesDerecha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelBotonesIzquierda = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Creación de los botones
        JButton botonVolver = new JButton("");
        BotonDerecha = new JButton("");
        BotonIzquierda = new JButton("");

        panelBotones.add(botonVolver);
        panelBotonesDerecha.add(BotonDerecha);
        panelBotonesIzquierda.add(BotonIzquierda);

        // Configuración del CardLayout
        cardLayout = new CardLayout();
        carrusel = new JPanel(cardLayout);

        // Crear las páginas
        JPanel pagina1 = crearPagina("Página 1", Color.RED);

        JTextArea definicion = new JTextArea(
                "La división es una operación matemática que "
                        + "consiste en repartir una cantidad en partes iguales");
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

        JPanel pagina2 = crearPagina("Página 2", Color.BLUE);
        JPanel pagina3 = crearPagina("Página 3", Color.GREEN);

        // Añadir las páginas al carrusel
        carrusel.add(pagina1, "pagina1");
        carrusel.add(pagina2, "pagina2");
        carrusel.add(pagina3, "pagina3");

        // Botón volver al menú principal
        botonVolver.setIcon(
                new ImageIcon(getClass().getResource("/botonAtras.png")));

        botonVolver.addActionListener(e -> {
            menuPrincipal ventana = new menuPrincipal();
            ventana.setVisible(true);
            this.dispose();
        });

        // Botón para avanzar
        BotonDerecha.setIcon(
                new ImageIcon(getClass().getResource("/flechaDere.jpg")));

        BotonDerecha.addActionListener(e -> {
            if (paginaActual < totalPaginas) {
                paginaActual++;
                cardLayout.show(carrusel, "pagina" + paginaActual);
                actualizarPagina();
            }
        });

        // Botón para retroceder
        BotonIzquierda.setIcon(
                new ImageIcon(getClass().getResource("/flechaIzq.jpg")));

        BotonIzquierda.addActionListener(e -> {
            if (paginaActual > 1) {
                paginaActual--;
                cardLayout.show(carrusel, "pagina" + paginaActual);
                actualizarPagina();
            }
        });

        // Actualizar visibilidad inicial de las flechas
        actualizarPagina();

        // Añadir los componentes a la ventana
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBotonesDerecha, BorderLayout.EAST);
        add(panelBotonesIzquierda, BorderLayout.WEST);
        add(rest, BorderLayout.NORTH);
        add(carrusel, BorderLayout.CENTER);
    }

    /**
     * Método auxiliar para construir las páginas.
     *
     * @param texto título que se mostrará en la página
     * @param color color de fondo
     * @return panel creado
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
     * Actualiza la visibilidad de los botones de navegación.
     */
    private void actualizarPagina() {

        BotonIzquierda.setVisible(paginaActual > 1);
        BotonDerecha.setVisible(paginaActual < totalPaginas);
    }
}
