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
 
    public boolean estaVivo() {
        return hp > 0;
    }
 
    public void atacar(Pokemon enemigo) {
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " causando " + atk + " puntos de daño.");
        enemigo.recibirDano(atk);
    }
 
    public void recibirDano(int dano) {
        hp -= dano;
        System.out.println(nombre + " ahora tiene " + hp + " HP.");
        if (hp <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }
}