package com.mycompany.proyectopokemon;

import javax.swing.JTextArea; // Importa la clase JTextArea

public class Batalla {
    private JTextArea textoArea; // Para actualizar los mensajes de la batalla

    public Batalla(JTextArea textoArea) {
        this.textoArea = textoArea;
    }

    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        textoArea.append(pokemon1.getNombre() + " vs " + pokemon2.getNombre() + "\n");

        while (pokemon1.estaVivo() && pokemon2.estaVivo()) {
            pokemon1.atacar(pokemon2);
            textoArea.append(pokemon1.getNombre() + " atacó a " + pokemon2.getNombre() + "\n");
            textoArea.append(pokemon2.getNombre() + " tiene " + pokemon2.getHp() + " HP restantes\n");

            if (pokemon2.estaVivo()) {
                pokemon2.atacar(pokemon1);
                textoArea.append(pokemon2.getNombre() + " atacó a " + pokemon1.getNombre() + "\n");
                textoArea.append(pokemon1.getNombre() + " tiene " + pokemon1.getHp() + " HP restantes\n");
            }

            // Pausa para que el usuario vea los eventos
            try {
                Thread.sleep(1000); // 1 segundo de pausa entre los turnos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (pokemon1.estaVivo()) {
            textoArea.append(pokemon1.getNombre() + " ganó la batalla!\n");
        } else {
            textoArea.append(pokemon2.getNombre() + " ganó la batalla!\n");
        }
    }
}
