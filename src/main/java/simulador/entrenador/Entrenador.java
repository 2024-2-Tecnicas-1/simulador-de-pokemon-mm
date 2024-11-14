package com.mycompany.proyectopokemon;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pokemon> equipo;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        inicializarEquipo();
    }

    private void inicializarEquipo() {
        equipo.add(new Pokemon("Ponyta", "Fuego", 50, 85));
        equipo.add(new Pokemon("Staryu", "Agua", 30, 45));
        equipo.add(new Pokemon("Bellsprout", "Planta/Veneno", 50, 75));
        equipo.add(new Pokemon("Magnemite", "Eléctrico/Acero", 25, 35));
        equipo.add(new Pokemon("Abra", "Psíquico", 25, 20));
        equipo.add(new Pokemon("Onix", "Roca/Tierra", 35, 45));
        equipo.add(new Pokemon("Doduo", "Normal/Volador", 35, 85));
    }

    public List<Pokemon> getEquipo() {
        return equipo;
    }

    public void mostrarEquipo() {
        System.out.println("Equipo de " + nombre + ":");
        for (int i = 0; i < equipo.size(); i++) {
            Pokemon p = equipo.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " - Tipo: " + p.getTipo() + ", HP: " + p.getHp() + ", ATK: " + p.getAtk());
        }
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

