/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juego_mates;

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
import javax.swing.JTextArea;

/**
 * Representa la interfaz gráfica y la lógica para el juego de restar.
 * Utiliza una estructura de carrusel (CardLayout) para mostrar diferentes páginas 
 * con ejercicios matemáticos de restas por niveles.
 * 
 * @author Héctor Ruiz Rivera
 * @version 1.0
 */
public class suma extends JFrame {

    /** Administrador de diseño para controlar el cambio de páginas en el carrusel. */
    private CardLayout cardLayout;
    
    /** Panel contenedor que almacena las diferentes páginas del juego. */
    private JPanel carrusel;
    
    /** Índice que rastrea la página en la que se encuentra la jugadora actualmente. */
    private int paginaActual = 1;
    
    /** Cantidad total de páginas de ejercicios disponibles. */
    private int totalPaginas = 3;

    /** Botón para avanzar a la siguiente página de restas. */
    private JButton BotonDerecha;
    
    /** Botón para retroceder a la página de restas anterior. */
    private JButton BotonIzquierda;

    /**
     * Constructor por defecto de la clase resta.
     * Configura los elementos gráficos del carrusel, carga las imágenes de las flechas,
     * inicializa los eventos de navegación y ensambla la interfaz de usuario.
     */
    public suma() {
        Random random = new Random();
        
        // Configuración y creación de la ventana
        setTitle("sumas");
        JLabel rest = new JLabel("¡Vamos a practicar las sumas!");
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

        cardLayout = new CardLayout();
        carrusel = new JPanel(cardLayout);

        // Crear las "páginas" del carrusel gráfico
        JPanel pagina1 = crearPagina("Definición de una suma", Color.RED);
        JTextArea definicion = new JTextArea("La suma matemática (o addición )"+
        " es la acción de juntar, unir o agregar dos o más cosas "+
        "o cantidades para saber cuántas hay en total");
        pagina1.add(definicion);
        definicion.setLineWrap(true);
        definicion.setWrapStyleWord(true);
        definicion.setEditable(false); // Evita que la jugadora pueda borrar o escribir en la definición
        JPanel pagina2 = crearPagina("Página 2", Color.BLUE);
        JPanel pagina3 = crearPagina("Página 3", Color.GREEN);

        carrusel.add(pagina1, "pagina1");
        carrusel.add(pagina2, "pagina2");
        carrusel.add(pagina3, "pagina3");
        
        // Configuración del botón de regresar al menú principal
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
        
        // Configuración del botón para ir a la derecha
        BotonDerecha.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaDere.jpg")
                )
        );
        BotonDerecha.addActionListener(e -> {
            if (paginaActual < totalPaginas) {
                paginaActual++;
                cardLayout.show(carrusel, "pagina" + paginaActual);
                actualizarPagina();
            }
        });

        // Configuración del botón para ir a la izquierda
        BotonIzquierda.setIcon(
                new javax.swing.ImageIcon(
                        getClass().getResource("/flechaIzq.jpg")
                )
        );
        BotonIzquierda.addActionListener(e -> {
            if (paginaActual > 1) {
                paginaActual--;
                cardLayout.show(carrusel, "pagina" + paginaActual);
                actualizarPagina();
            }
        });
        
        // Inicializa la visibilidad de las flechas según la página inicial
        actualizarPagina();

        // Añadimos los paneles y componentes a la ventana principal
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBotonesDerecha, BorderLayout.EAST);
        add(panelBotonesIzquierda, BorderLayout.WEST);
        add(rest, BorderLayout.NORTH);
        add(carrusel, BorderLayout.CENTER);
    }

    /**
     * Helper o método auxiliar para construir dinámicamente los paneles 
     * que servirán como páginas en el juego.
     *
     * @param texto El título o contenido textual que se mostrará en el centro del panel.
     * @param color El color de fondo que tendrá el panel generado.
     * @return Un objeto {@link JPanel} configurado con el fondo y la etiqueta correspondientes.
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
     * Actualiza la visibilidad de los botones de navegación (BotonIzquierda y BotonDerecha) 
     * dependiendo de la página del carrusel en la que se encuentre actualmente el usuario.
     */
    private void actualizarPagina() {
        BotonIzquierda.setVisible(paginaActual > 1);
        BotonDerecha.setVisible(paginaActual < totalPaginas);
    }
}
