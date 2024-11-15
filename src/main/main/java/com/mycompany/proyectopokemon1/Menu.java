package com.mycompany.proyectopokemon1;
 
import java.util.Scanner;
 
public class Menu {
    private Entrenador entrenador;
    private Scanner scanner;
 
    public Menu(Entrenador entrenador) {
        this.entrenador = entrenador;
        this.scanner = new Scanner(System.in);
    }
 
    public void mostrarMenu() {
        boolean continuar = true;
        
        System.out.println("¡Bienvenido al simulador de batallas Pokémon!");
 
        while (continuar) {
            System.out.println("\n¿Qué te gustaría hacer?");
            System.out.println("1. Mostrar equipo Pokémon");
            System.out.println("2. Entrenar un Pokémon");
            System.out.println("3. Iniciar una batalla entre dos Pokémon");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
 
            switch (opcion) {
                case 1:
                    entrenador.mostrarEquipo();
                    break;
                case 2:
                    entrenarPokemon();
                    break;
                case 3:
                    iniciarBatalla();
                    break;
                case 4:
                    System.out.println("¡Gracias por jugar! Hasta luego.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
 
        scanner.close();
    }
 
    private void entrenarPokemon() {
        entrenador.mostrarEquipo();
        System.out.print("Selecciona el índice del Pokémon que quieres entrenar (1-7): ");
        int index = scanner.nextInt() - 1;
 
        if (index >= 0 && index < entrenador.getEquipo().size()) {
            Pokemon pokemon = entrenador.getEquipo().get(index);
            System.out.println("Entrenando a " + pokemon.getNombre() + "...");
            int nuevoHP = pokemon.getHp() + 5;
            int nuevoATK = pokemon.getAtk() + 3;
            pokemon.setHp(nuevoHP);
            pokemon.setAtk(nuevoATK);
            System.out.println(pokemon.getNombre() + " ahora tiene " + nuevoHP + " HP y " + nuevoATK + " ATK.");
        } else {
            System.out.println("Índice no válido.");
        }
    }
 
    private void iniciarBatalla() {
        entrenador.mostrarEquipo();
 
        System.out.print("Selecciona el primer Pokémon (1-7): ");
        int index1 = scanner.nextInt() - 1;
 
        System.out.print("Selecciona el segundo Pokémon (1-7): ");
        int index2 = scanner.nextInt() - 1;
 
        if (index1 >= 0 && index1 < 7 && index2 >= 0 && index2 < 7 && index1 != index2) {
            Pokemon pokemon1 = entrenador.getEquipo().get(index1);
            Pokemon pokemon2 = entrenador.getEquipo().get(index2);
 
            Batalla batalla = new Batalla();
            batalla.iniciarBatalla(pokemon1, pokemon2);
        } else {
            System.out.println("Selección no válida. Asegúrate de elegir Pokémon diferentes y dentro del rango.");
        }
    }
}

 