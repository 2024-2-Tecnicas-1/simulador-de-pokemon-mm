package com.mycompany.proyectopokemon1;

import java.util.Scanner;

public class Batalla {
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Comienza la batalla!");
        while (pokemon1.getHp() > 0 && pokemon2.getHp() > 0) {
            System.out.println("\nEs el turno de " + pokemon1.getNombre() + " y " + pokemon2.getNombre());
            System.out.println("Selecciona la acción: A para " + pokemon1.getNombre() + " ataque, B para " + pokemon2.getNombre() + " ataque.");
            String accion = scanner.nextLine();

            if (accion.equalsIgnoreCase("A")) {
                pokemon1.atacar(pokemon2);
            } else if (accion.equalsIgnoreCase("B")) {
                pokemon2.atacar(pokemon1);
            } else {
                System.out.println("Acción no válida.");
                continue;
            }

            if (pokemon1.getHp() <= 0) {
                System.out.println(pokemon1.getNombre() + " ha sido derrotado.");
                System.out.println(pokemon2.getNombre() + " gana la batalla!");
                break;
            } else if (pokemon2.getHp() <= 0) {
                System.out.println(pokemon2.getNombre() + " ha sido derrotado.");
                System.out.println(pokemon1.getNombre() + " gana la batalla!");
                break;
            }
        }
    }
}