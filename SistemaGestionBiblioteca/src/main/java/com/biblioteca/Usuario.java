package com.biblioteca;

public class Usuario extends Persona {
    private int prestamos;

    public Usuario(int id, String nombre, String apellido, int prestamos) {
        super(id, nombre, apellido, "Usuario");
        this.prestamos = prestamos;
    }

    // Getters y Setters
    public int getPrestamos() { return prestamos; }
    public void setPrestamos(int prestamos) { this.prestamos = prestamos; }
}