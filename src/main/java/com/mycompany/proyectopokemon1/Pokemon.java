package com.mycompany.proyectopokemon1;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int hp;
    private int atk;

    public Pokemon(String nombre, String tipo, int hp, int atk) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.hp = hp;
        this.atk = atk;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void atacar(Pokemon oponente) {
        oponente.setHp(oponente.getHp() - this.atk);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + this.atk + " puntos de daño.");
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - HP: " + hp + ", ATK: " + atk;
    }
}
