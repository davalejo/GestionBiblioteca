package com.biblioteca;

import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            System.out.println("Conexión exitosa a la base de datos.");

            // Ejemplo: Agregar un nuevo libro
            Libro nuevoLibro = new Libro(0,"El Aleph", "Borges", "4455667788", true);
            LibroDAO libroDAO = new LibroDAO();
            libroDAO.agregarLibro(nuevoLibro);

            // Ejemplo: Obtener un libro por ID
            Libro libroObtenido = libroDAO.obtenerLibroPorID(1);
            System.out.println("Título del libro obtenido: " + libroObtenido.getTitulo());

            // Simulación de préstamos y devoluciones aquí...

        } catch(SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        }
    }
}