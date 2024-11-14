package com.mycompany.proyectopokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private Entrenador entrenador;
    private JFrame ventana;
    private JPanel panel;
    private JTextArea textoArea;
    private JComboBox<String> pokemonComboBox1;
    private JComboBox<String> pokemonComboBox2;
    private JButton btnMostrarEquipo;
    private JButton btnEntrenar;
    private JButton btnBatallar;

    public Menu(Entrenador entrenador) {
        this.entrenador = entrenador;
        this.ventana = new JFrame("Simulador Pokémon");
        this.panel = new JPanel();
        this.textoArea = new JTextArea(15, 40);
        this.textoArea.setEditable(false);
        this.textoArea.setText("¡Bienvenido al simulador de batallas Pokémon!\n");

        
        String[] nombresPokemon = new String[entrenador.getEquipo().size()];
        for (int i = 0; i < entrenador.getEquipo().size(); i++) {
            nombresPokemon[i] = entrenador.getEquipo().get(i).getNombre();
        }

        pokemonComboBox1 = new JComboBox<>(nombresPokemon);
        pokemonComboBox2 = new JComboBox<>(nombresPokemon);

      
        btnMostrarEquipo = new JButton("Mostrar equipo");
        btnEntrenar = new JButton("Entrenar Pokémon");
        btnBatallar = new JButton("Iniciar Batalla");

        configurarVentana();
    }

    private void configurarVentana() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setLayout(new BorderLayout());

        
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Selecciona Pokémon para la batalla:"));
        panel.add(pokemonComboBox1);
        panel.add(pokemonComboBox2);
        panel.add(btnBatallar);

       
        panel.add(btnMostrarEquipo);

     
        panel.add(btnEntrenar);

       
        JScrollPane scrollPane = new JScrollPane(textoArea);
        panel.add(scrollPane);

        ventana.add(panel, BorderLayout.CENTER);
        ventana.setVisible(true);

        agregarEventos();
    }

    private void agregarEventos() {
        btnMostrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEquipo();
            }
        });

        btnEntrenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrenarPokemon();
            }
        });

        btnBatallar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarBatalla();
            }
        });
    }

    private void mostrarEquipo() {
        textoArea.setText("Equipo de " + entrenador.getNombre() + ":\n");
        for (Pokemon p : entrenador.getEquipo()) {
            textoArea.append(p.getNombre() + " - Tipo: " + p.getTipo() + ", HP: " + p.getHp() + ", ATK: " + p.getAtk() + "\n");
        }
    }

    private void entrenarPokemon() {
        int index = pokemonComboBox1.getSelectedIndex();
        if (index >= 0) {
            Pokemon pokemon = entrenador.getEquipo().get(index);
            pokemon.setHp(pokemon.getHp() + 5);
            pokemon.setAtk(pokemon.getAtk() + 3);
            textoArea.append("\n" + pokemon.getNombre() + " ha sido entrenado! Ahora tiene " + pokemon.getHp() + " HP y " + pokemon.getAtk() + " ATK.\n");
        }
    }

    private void iniciarBatalla() {
        int index1 = pokemonComboBox1.getSelectedIndex();
        int index2 = pokemonComboBox2.getSelectedIndex();

        if (index1 != index2 && index1 >= 0 && index2 >= 0) {
            Pokemon pokemon1 = entrenador.getEquipo().get(index1);
            Pokemon pokemon2 = entrenador.getEquipo().get(index2);

            
            Batalla batalla = new Batalla(textoArea);
            batalla.iniciarBatalla(pokemon1, pokemon2);
        } else {
            textoArea.append("\nSelecciona dos Pokémon diferentes para la batalla.\n");
        }
    }
}
