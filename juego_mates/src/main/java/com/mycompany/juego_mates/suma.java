/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.JTextField;

/**
 * Representa la interfaz gráfica y la lógica para el juego de restar.
 * Utiliza una estructura de carrusel (CardLayout) para mostrar diferentes
 * páginas
 * con ejercicios matemáticos de restas por niveles.
 * 
 * @author Héctor Ruiz Rivera
 * @version 1.0
 */
public class suma extends JFrame {
    Random random = new Random();
    int sumando1 = 0;
    int sumando2 = 0;
    int resultado = 0;

    /**
     * Administrador de diseño para controlar el cambio de páginas en el carrusel.
     */
    private CardLayout cardLayout;

    /** Panel contenedor que almacena las diferentes páginas del juego. */
    private JPanel carrusel;

    /**
     * Índice que rastrea la página en la que se encuentra la jugadora actualmente.
     */
    private int paginaActual = 1;

    /** Cantidad total de páginas de ejercicios disponibles. */
    private int totalPaginas = 3;

    /** Botón para avanzar a la siguiente página de restas. */
    private JButton BotonDerecha;

    /** Botón para retroceder a la página de restas anterior. */
    private JButton BotonIzquierda;
    private JLabel calculoSuma;
    /**
     * Constructor por defecto de la clase resta.
     * Configura los elementos gráficos del carrusel, carga las imágenes de las
     * flechas,
     * inicializa los eventos de navegación y ensambla la interfaz de usuario.
     */
    private JTextField respuestaJugador;

    public suma() {

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
        JTextArea definicion = new JTextArea("La suma matemática (o addición )" +
                " es la acción de juntar, unir o agregar dos o más cosas " +
                "o cantidades para saber cuántas hay en total");

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

        JPanel pagina2 = crearPartesSuma();

        JPanel pagina3 = crearPagina("Ejercios prácticos", Color.GREEN);
        respuestaJugador = new JTextField();
        pagina3.add(respuestaJugador);
        JPanel pagina = new JPanel(new BorderLayout());
        JLabel calculoSuma = new JLabel();
        calculoSuma.setForeground(Color.BLUE);
        calculoSuma.setText(sumando1 + " + " + sumando2 + " = " + resultado);
        pagina3.add(calculoSuma);
        carrusel.add(pagina1, "pagina1");
        carrusel.add(pagina2, "pagina2");
        carrusel.add(pagina3, "pagina3");

        // Configuración del botón de regresar al menú principal
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
                cardLayout.show(carrusel, "pagina" + paginaActual);
                if (paginaActual == 3) {
                    generarSuma();
                }
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

    private JPanel crearPartesSuma() {
        JPanel pagina = new JPanel(new BorderLayout());
        JPanel operacion = new JPanel(new FlowLayout());
        JLabel explicacion = new JLabel("Pulsa un botón");
        JButton Sumando1 = new JButton("25");
        JButton Sumando2 = new JButton("30");
        JButton operador = new JButton("+");
        JButton igualdad = new JButton("=");
        JButton resultado = new JButton("55");
        JPanel centroImg = new JPanel(new BorderLayout());
        ImageIcon icono = new ImageIcon(getClass().getResource("/parteSuma.jpg"));
        JLabel imagen = new JLabel(icono);
        Sumando1.addActionListener(e -> {
            explicacion.setText("Este es el primer sumando");
        });

        operador.addActionListener(e -> {
            explicacion.setText("Este es el operador suma");

        });

        Sumando2.addActionListener(e -> {
            explicacion.setText("Este es el segundo sumando");

        });
        igualdad.addActionListener(e -> {
            explicacion.setText("Este es el igual o igualdad");

        });
        resultado.addActionListener(e -> {
            explicacion.setText("Este es el resultado");

        });
        explicacion.setHorizontalAlignment(JLabel.CENTER);
        pagina.add(centroImg, BorderLayout.CENTER);
        pagina.add(explicacion, BorderLayout.NORTH);
        operacion.add(Sumando1);
        operacion.add(operador);
        operacion.add(Sumando2);
        operacion.add(igualdad);
        operacion.add(resultado);
        centroImg.add(operacion, BorderLayout.NORTH);
        centroImg.add(imagen, BorderLayout.CENTER);
        return pagina;

    }

    /**
     * Helper o método auxiliar para construir dinámicamente los paneles
     * que servirán como páginas en el juego.
     *
     * @param texto El título o contenido textual que se mostrará en el centro del
     *              panel.
     * @param color El color de fondo que tendrá el panel generado.
     * @return Un objeto {@link JPanel} configurado con el fondo y la etiqueta
     *         correspondientes.
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
     * Actualiza la visibilidad de los botones de navegación (BotonIzquierda y
     * BotonDerecha)
     * dependiendo de la página del carrusel en la que se encuentre actualmente el
     * usuario.
     */
    private void actualizarPagina() {
        BotonIzquierda.setVisible(paginaActual > 1);
        BotonDerecha.setVisible(paginaActual < totalPaginas);
    }

    private void generarSuma() {
        sumando1 = random.nextInt(100) + 1;
        sumando2 = random.nextInt(100) + 1;
        resultado = sumando1 + sumando2;

    }
}