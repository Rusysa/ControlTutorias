/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author rudy
 */

import db.conexion;
import interfaz.altas.tutorComboBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class tutoradoMetodos {
    conexion conexion = new conexion();
    // MÉTODO 1: Obtener lista de tutores para el ComboBox
    public List<tutorComboBox> obtenerTutores() {
        List<tutorComboBox> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM Tutor WHERE eliminado = 0";

        try (Connection conn = conexion.establecerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new tutorComboBox(
                    rs.getInt("id"),
                    rs.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar tutores: " + e.getMessage());
        }
        return lista;
    }

    // MÉTODO 2: Crear Tutorado (Create)
    // Nota: No pedimos user_id, se insertará como NULL automáticamente
    public boolean crearTutorado(int tutorId, String nombre, String aPaterno, String aMaterno, 
                             String matricula, String carrera, String status, 
                             String telefono, String telEmergencia, String domicilio,
                             int afis, String fechaInscripcion) { // <--- Nuevos parámetros
    
    // Agregamos afis y fecha_inscripcion a la consulta
    String sql = "INSERT INTO Tutorados (tutor_id, nombre, apellido_paterno, apellido_materno, " +
                 "matricula, carrera, status, telefono, telefono_emergencia, domicilio, " +
                 "afis, fecha_inscripcion, user_id) " + 
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL)";

    try (Connection conn = conexion.establecerConexion();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, tutorId);
        pstmt.setString(2, nombre);
        pstmt.setString(3, aPaterno);
        pstmt.setString(4, aMaterno);
        pstmt.setString(5, matricula);
        pstmt.setString(6, carrera);
        pstmt.setString(7, status);
        pstmt.setString(8, telefono);
        pstmt.setString(9, telEmergencia);
        pstmt.setString(10, domicilio);
        
        // --- Nuevos campos ---
        pstmt.setInt(11, afis); 
        pstmt.setString(12, fechaInscripcion); 
        // ---------------------

        pstmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error al guardar tutorado: " + e.getMessage());
        return false;
    }
}
}
