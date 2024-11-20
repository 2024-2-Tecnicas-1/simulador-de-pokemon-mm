package com.mycompany.proyectopokemon1;

import java.util.Scanner;

public class ProyectoPokemon1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("¡Bienvenido al simulador de batallas Pokémon!\nIntroduce tu nombre de entrenador: ");
        String nombreEntrenador = scanner.nextLine();
        Entrenador entrenador = new Entrenador(nombreEntrenador);

        // Crear algunos Pokémon predefinidos para el equipo inicial
        entrenador.agregarPokemon(new Pokemon("Ponyta", "Fuego", 50, 12));
        entrenador.agregarPokemon(new Pokemon("Staryu", "Agua", 45, 10));

        // Mostrar el menú
        Menu menu = new Menu(entrenador, scanner);
        menu.mostrarMenu();
    }
}
