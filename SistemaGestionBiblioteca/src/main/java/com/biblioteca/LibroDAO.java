package com.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroDAO {

    // Agregar un libro
    public void agregarLibro(Libro libro) {
        String sql = "INSERT INTO Libro(titulo, autor, isbn, disponible) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getIsbn());
            pstmt.setBoolean(4, libro.isDisponible());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar un libro
    public void actualizarLibro(Libro libro) {
        String sql = "UPDATE Libro SET titulo=?, autor=?, isbn=?, disponible=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getIsbn());
            pstmt.setBoolean(4, libro.isDisponible());
            pstmt.setInt(5, libro.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un libro
    public void eliminarLibro(int id) {
        String sql = "DELETE FROM Libro WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener un libro por ID
    public Libro obtenerLibroPorID(int id) {
        Libro libro = null;
        String sql = "SELECT * FROM Libro WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn"),
                        rs.getBoolean("disponible")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }
}