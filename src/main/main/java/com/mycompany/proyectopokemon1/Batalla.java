package com.mycompany.proyectopokemon1;
 
public class Batalla {
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.println("\n¡Comienza la batalla entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre() + "!\n");
 
        while (pokemon1.estaVivo() && pokemon2.estaVivo()) {
            pokemon1.atacar(pokemon2);
            if (pokemon2.estaVivo()) {
                pokemon2.atacar(pokemon1);
            }
        }
 
        if (pokemon1.estaVivo()) {
            System.out.println(pokemon1.getNombre() + " ganó la batalla!");
        } else {
            System.out.println(pokemon2.getNombre() + " ganó la batalla!");
        }
    }
}
 