/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labbb1;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {

    private PalindromoAir air = new PalindromoAir();
    private JButton[] botonesAsientos = new JButton[30];
    private JTextField campoNombre = new JTextField();
    private JTextArea consola = new JTextArea();
    private int asientoSeleccionado = -1;

    public MainApp() {
        setTitle("PalindromoAir");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panelAsientos = new JPanel(new GridLayout(5, 6));
        panelAsientos.setBounds(20, 20, 400, 200);
        add(panelAsientos);

        JPanel leyenda = new JPanel();
        leyenda.setLayout(null);
        leyenda.setBounds(440, 20, 220, 100);
        add(leyenda);

        JPanel verdeBox = new JPanel();
        verdeBox.setBackground(Color.GREEN);
        verdeBox.setBounds(10, 10, 20, 20);
        leyenda.add(verdeBox);

        JLabel verdeLabel = new JLabel("Asiento disponible");
        verdeLabel.setBounds(40, 10, 150, 20);
        leyenda.add(verdeLabel);

        JPanel rojoBox = new JPanel();
        rojoBox.setBackground(Color.RED);
        rojoBox.setBounds(10, 35, 20, 20);
        leyenda.add(rojoBox);

        JLabel rojoLabel = new JLabel("Asiento ocupado");
        rojoLabel.setBounds(40, 35, 150, 20);
        leyenda.add(rojoLabel);

        JPanel azulBox = new JPanel();
        azulBox.setBackground(Color.BLUE);
        azulBox.setBounds(10, 60, 20, 20);
        leyenda.add(azulBox);

        JLabel azulLabel = new JLabel("Nombre palindromo");
        azulLabel.setBounds(40, 60, 150, 20);
        leyenda.add(azulLabel);

        for (int i = 0; i < 30; i++) {
            int asiento = i;
            JButton boton = new JButton((i + 1) + "");
            boton.setBackground(Color.GREEN);
            boton.addActionListener(e -> {
                asientoSeleccionado = asiento;
                consola.setText("Asiento seleccionado: #" + (asiento + 1));
            });
            botonesAsientos[i] = boton;
            panelAsientos.add(boton);
        }

        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(20, 240, 100, 25);
        add(labelNombre);

        campoNombre.setBounds(90, 240, 200, 25);
        add(campoNombre);

        JButton sellBtn = new JButton("Sell Ticket");
        sellBtn.setBounds(20, 280, 120, 30);
        add(sellBtn);

        JButton cancelBtn = new JButton("Cancel Ticket");
        cancelBtn.setBounds(150, 280, 120, 30);
        add(cancelBtn);

        JButton dispatchBtn = new JButton("Dispatch");
        dispatchBtn.setBounds(280, 280, 100, 30);
        add(dispatchBtn);

        JButton printBtn = new JButton("Print Passengers");
        printBtn.setBounds(400, 280, 150, 30);
        add(printBtn);

        JButton incomeBtn = new JButton("View Income");
        incomeBtn.setBounds(20, 320, 120, 30);
        add(incomeBtn);

        JButton searchBtn = new JButton("Search Passenger");
        searchBtn.setBounds(150, 320, 170, 30);
        add(searchBtn);

        consola.setEditable(false);
        JScrollPane scroll = new JScrollPane(consola);
        scroll.setBounds(20, 370, 630, 160);
        add(scroll);

        sellBtn.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            if (asientoSeleccionado == -1) { 
                consola.setText("Seleccione un asiento.");
                return;
            }
            if (nombre.isEmpty()) {
                consola.setText("Ingrese un nombre.");
                return;
            }
            if (air.getAsientos()[asientoSeleccionado] != null) {
                consola.setText("Ese asiento ya esta ocupado.");
                return;
            }
            boolean esPalin = air.isPalindromo(nombre);
            double original = 100.0;
            double total = esPalin ? original * 0.8 : original;
            Ticket t = new Ticket(nombre, total, original, esPalin);
            air.getAsientos()[asientoSeleccionado] = t;
            botonesAsientos[asientoSeleccionado].setBackground(esPalin ? Color.BLUE : Color.RED);
            botonesAsientos[asientoSeleccionado].setText(nombre.substring(0, 1).toUpperCase());
            consola.setText("Ticket vendido en asiento #" + (asientoSeleccionado + 1) + " a " + nombre);
            asientoSeleccionado = -1;
        });

        cancelBtn.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            int posicion = air.searchPassenger(nombre, 0);
            if (posicion == -1) {
                consola.setText("Pasajero no encontrado.");
            } else {
                air.getAsientos()[posicion] = null;
                botonesAsientos[posicion].setBackground(Color.GREEN);
                botonesAsientos[posicion].setText((posicion + 1) + "");
                consola.setText("Ticket cancelado para " + nombre);
            }
        });

        dispatchBtn.addActionListener(e -> {
            double total = air.income(0);
            air.reset(0);
            for (int i = 0; i < 30; i++) {
                botonesAsientos[i].setBackground(Color.GREEN);
                botonesAsientos[i].setText((i + 1) + "");
            }
            consola.setText("Ingreso total: $" + total + "\nTodos los asientos fueron liberados.");
        });

        printBtn.addActionListener(e -> {
            consola.setText(air.printPassengers(0));
        });

        incomeBtn.addActionListener(e -> {
            consola.setText("Ingreso total: $" + air.income(0));
        });

        searchBtn.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            int posicion = air.searchPassenger(nombre, 0);
            if (posicion == -1) {
                consola.setText("Pasajero no encontrado.");
            } else {
                consola.setText("Pasajero " + nombre + " esta en el asiento #" + (posicion + 1));
            }
        });
    }

    public static void main(String[] args) {
        new MainApp().setVisible(true);
    }
}
