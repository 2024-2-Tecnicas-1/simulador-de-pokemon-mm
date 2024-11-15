package com.mycompany.proyectopokemon1;
 
public class ProyectoPokemon1 {
    public static void main(String[] args) {
        Entrenador entrenador = new Entrenador("Ash");
        Menu menu = new Menu(entrenador);
        menu.mostrarMenu();
    }
}