package com.mycompany.proyectopokemon1;

import java.util.Scanner;

public class Menu {
    private Entrenador entrenador;
    private Scanner scanner;

    public Menu(Entrenador entrenador, Scanner scanner) {
        this.entrenador = entrenador;
        this.scanner = scanner;
    }

    

    public void mostrarMenu() {
        boolean continuar = true;

        System.out.println("\n¡Entrenador " + entrenador.getNombre() + ", prepárate para la aventura Pokémon!");

        while (continuar) {
            System.out.println("\n¿Qué te gustaría hacer?");
            System.out.println("1. Mostrar equipo Pokémon");
            System.out.println("2. Entrenar un Pokémon");
            System.out.println("3. Iniciar una batalla entre dos Pokémon");
            System.out.println("4. Agregar un Pokémon");
            System.out.println("5. Quitar un Pokémon");
            System.out.println("6. Cambiar entrenador");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = obtenerOpcion();
            if (opcion == -1) {
                continue;  // Si hay un error en la entrada, vuelve a pedir la opción
            }

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
                    agregarPokemon();
                    break;
                case 5:
                    quitarPokemon();
                    break;
                case 6:
                    cambiarEntrenador();
                    break;
                case 7:
                    System.out.println("¡Gracias por jugar, " + entrenador.getNombre() + "! Hasta luego.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }

    private void cambiarEntrenador() {
        System.out.print("Introduce el nombre del nuevo entrenador: ");
        scanner.nextLine();  // Consumir la línea pendiente
        String nuevoNombre = scanner.nextLine();
        this.entrenador = new Entrenador(nuevoNombre);
        System.out.println("¡Nuevo entrenador " + nuevoNombre + " creado!");
    }

    private int obtenerOpcion() {
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Por favor ingresa un número válido.");
            scanner.nextLine();  // Limpiar el buffer de entrada
            return -1;
        }
    }

    private void entrenarPokemon() {
        if (entrenador.getEquipo().isEmpty()) {
            System.out.println("No tienes Pokémon en tu equipo para entrenar. Agrega uno primero.");
            return;
        }

        entrenador.mostrarEquipo();
        System.out.print("Selecciona el índice del Pokémon que quieres entrenar (1-" + entrenador.getEquipo().size() + "): ");
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
        if (entrenador.getEquipo().size() < 2) {
            System.out.println("Necesitas al menos 2 Pokémon en tu equipo para iniciar una batalla.");
            return;
        }

        entrenador.mostrarEquipo();
        System.out.print("Selecciona el primer Pokémon (1-" + entrenador.getEquipo().size() + "): ");
        int index1 = scanner.nextInt() - 1;

        System.out.print("Selecciona el segundo Pokémon (1-" + entrenador.getEquipo().size() + "): ");
        int index2 = scanner.nextInt() - 1;

        if (index1 >= 0 && index1 < entrenador.getEquipo().size() && index2 >= 0 && index2 < entrenador.getEquipo().size() && index1 != index2) {
            Pokemon pokemon1 = entrenador.getEquipo().get(index1);
            Pokemon pokemon2 = entrenador.getEquipo().get(index2);

            Batalla batalla = new Batalla();
            batalla.iniciarBatalla(pokemon1, pokemon2);
        } else {
            System.out.println("Selección no válida. Asegúrate de elegir Pokémon diferentes y dentro del rango.");
        }
    }

    private void agregarPokemon() {
        if (entrenador.getEquipo().size() >= 7) {
            System.out.println("El equipo ya tiene 7 Pokémon. No puedes agregar más.");
            return;
        }

        System.out.print("Introduce el nombre del Pokémon: ");
        scanner.nextLine(); // Consumir la línea pendiente
        String nombre = scanner.nextLine();
        System.out.print("Introduce el tipo del Pokémon: ");
        String tipo = scanner.nextLine();
        System.out.print("Introduce los HP del Pokémon: ");
        int hp = scanner.nextInt();
        System.out.print("Introduce el ATK del Pokémon: ");
        int atk = scanner.nextInt();

        Pokemon nuevoPokemon = new Pokemon(nombre, tipo, hp, atk);
        entrenador.agregarPokemon(nuevoPokemon);
        System.out.println("¡" + nombre + " fue agregado exitosamente al equipo!");
    }

    private void quitarPokemon() {
        if (entrenador.getEquipo().isEmpty()) {
            System.out.println("No tienes Pokémon en tu equipo para quitar.");
            return;
        }

        entrenador.mostrarEquipo();
        System.out.print("Selecciona el índice del Pokémon que deseas quitar (1-" + entrenador.getEquipo().size() + "): ");
        int index = scanner.nextInt() - 1;

        if (entrenador.quitarPokemon(index)) {
            System.out.println("¡Pokémon quitado exitosamente!");
        } else {
            System.out.println("Índice no válido.");
        }
    }
}
