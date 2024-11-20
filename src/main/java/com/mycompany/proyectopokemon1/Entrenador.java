package com.mycompany.proyectopokemon1;

import java.util.ArrayList;

public class Entrenador {
    private String nombre;
    private ArrayList<Pokemon> equipo;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

    public void agregarPokemon(Pokemon pokemon) {
        if (equipo.size() < 7) {
            equipo.add(pokemon);
        } else {
            System.out.println("El equipo ya tiene 7 Pokémon.");
        }
    }

    public boolean quitarPokemon(int index) {
        if (index >= 0 && index < equipo.size()) {
            equipo.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void mostrarEquipo() {
        if (equipo.isEmpty()) {
            System.out.println("Tu equipo está vacío.");
        } else {
            System.out.println("Equipo de " + nombre + ":");
            for (int i = 0; i < equipo.size(); i++) {
                System.out.println((i + 1) + ". " + equipo.get(i));
            }
        }
    }
}