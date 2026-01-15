/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author rudy
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;

public class crearDb {

    private Connection conectar = null;
    // Definimos la ruta: src/db/ (Multiplataforma)
    private final String rutaCarpeta = "src" + File.separator + "main" + File.separator + "java" + File.separator + "db";
    private final String archivoBD = "dtabase.db";
    // Cadena de conexión
    private final String cadena = "jdbc:sqlite:" + System.getProperty("user.dir") 
                                  + File.separator + rutaCarpeta 
                                  + File.separator + archivoBD;
//  LA FUNCION DE ESTABLCER CONEXION TAMBIEN TIENE LA FUNCION PARA CREAR LAS TABLAS
    public Connection establecerConexion() {
        try {
            // 1. Verificar y crear carpetas si no existen
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    System.out.println("Carpeta 'db/db.db' creada.");
                }
            }

            // 2. Cargar Driver
            Class.forName("org.sqlite.JDBC");

            // 3. Conectar (Crea el archivo si no existe)
            conectar = DriverManager.getConnection(cadena);
            
            // 4. Activar Foreign Keys (SQLite las tiene desactivadas por defecto)
            Statement pragmaStmt = conectar.createStatement();
            pragmaStmt.execute("PRAGMA foreign_keys = ON;");
            pragmaStmt.close();

            // 5. AQUI SE CREAN LAS TABLAS
            crearTablas();

            System.out.println("Conexion a la base de datos exitosa.");

        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.toString());
        }
        return conectar;
    }

    private void crearTablas() {
        // Usamos StringBuilder para construir el SQL largo de forma eficiente
        StringBuilder sql = new StringBuilder();

        sql.append("BEGIN TRANSACTION;");
        
        sql.append("CREATE TABLE IF NOT EXISTS \"User\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"correo\" TEXT NOT NULL UNIQUE,")
           .append(" \"pass\" TEXT NOT NULL,")
           .append(" \"role\" TEXT NOT NULL CHECK(\"role\" IN ('Admin', 'Tutorado', 'Tutor')),")
           .append(" \"creado_el\" TEXT DEFAULT CURRENT_TIMESTAMP,")
           .append(" \"eliminado\" INTEGER DEFAULT 0);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Administrador\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"user_id\" INTEGER NOT NULL UNIQUE,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"user_id\") REFERENCES \"User\"(\"id\") ON DELETE CASCADE);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Tutor\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"user_id\" INTEGER NOT NULL UNIQUE,")
           .append(" \"nombre\" TEXT NOT NULL,")
           .append(" \"apellido_paterno\" TEXT NOT NULL,")
           .append(" \"apellido_materno\" TEXT NOT NULL,")
           .append(" \"telefono\" TEXT UNIQUE,")
           .append(" \"direccion\" TEXT,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"user_id\") REFERENCES \"User\"(\"id\") ON DELETE CASCADE);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Tutorados\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"user_id\" INTEGER NOT NULL UNIQUE,")
           .append(" \"tutor_id\" INTEGER,")
           .append(" \"nombre\" TEXT NOT NULL,")
           .append(" \"apellido_paterno\" TEXT NOT NULL,")
           .append(" \"apellido_materno\" TEXT NOT NULL,")
           .append(" \"matricula\" TEXT NOT NULL UNIQUE,")
           .append(" \"carrera\" TEXT NOT NULL,")
           .append(" \"status\" TEXT NOT NULL,")
           .append(" \"telefono\" TEXT UNIQUE,")
           .append(" \"telefono_emergencia\" TEXT UNIQUE,")
           .append(" \"domicilio\" TEXT,")
           .append(" \"fecha_inscripcion\" TEXT,")
           .append(" \"afis\" INTEGER DEFAULT 0,")
           .append(" \"promedio_general\" REAL DEFAULT 0.0,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"tutor_id\") REFERENCES \"Tutor\"(\"id\") ON DELETE SET NULL,")
           .append(" FOREIGN KEY(\"user_id\") REFERENCES \"User\"(\"id\") ON DELETE CASCADE);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Periodo\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"ciclo\" TEXT NOT NULL,")
           .append(" \"parte\" TEXT CHECK(\"parte\" IN ('A', 'B')),") // Corregido el parentesis aquí
           .append(" \"es_activo\" INTEGER DEFAULT 0,")
           .append(" \"eliminado\" INTEGER DEFAULT 0);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Inscripciones\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"tutorado_id\" INTEGER NOT NULL,")
           .append(" \"periodo_id\" INTEGER NOT NULL,")
           .append(" \"semestre\" INTEGER NOT NULL,")
           .append(" \"estado_pago\" INTEGER DEFAULT 0,")
           .append(" \"promedio_semestral\" REAL DEFAULT 0.0,")
           .append(" \"num_justificantes\" INTEGER DEFAULT 0,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"periodo_id\") REFERENCES \"Periodo\"(\"id\") ON DELETE RESTRICT,")
           .append(" FOREIGN KEY(\"tutorado_id\") REFERENCES \"Tutorados\"(\"id\") ON DELETE CASCADE);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Sesiones\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"periodo_id\" INTEGER NOT NULL,")
           .append(" \"tutor_id\" INTEGER NOT NULL,")
           .append(" \"tipo_sesion\" TEXT NOT NULL,")
           .append(" \"fecha\" TEXT NOT NULL,")
           .append(" \"tema\" TEXT,")
           .append(" \"comentarios\" TEXT,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"periodo_id\") REFERENCES \"Periodo\"(\"id\"),")
           .append(" FOREIGN KEY(\"tutor_id\") REFERENCES \"Tutor\"(\"id\"));");

        sql.append("CREATE TABLE IF NOT EXISTS \"Asistencias\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"sesion_id\" INTEGER NOT NULL,")
           .append(" \"inscripcion_id\" INTEGER NOT NULL,")
           .append(" \"estado\" TEXT CHECK(\"estado\" IN ('Falta', 'Asistio', 'Justificado')),")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"inscripcion_id\") REFERENCES \"Inscripciones\"(\"id\") ON DELETE CASCADE,")
           .append(" FOREIGN KEY(\"sesion_id\") REFERENCES \"Sesiones\"(\"id\") ON DELETE CASCADE);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Calificaciones\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"inscripcion_id\" INTEGER NOT NULL,")
           .append(" \"valor\" REAL NOT NULL,")
           .append(" \"tipo\" TEXT,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"inscripcion_id\") REFERENCES \"Inscripciones\"(\"id\") ON DELETE CASCADE);");

        sql.append("CREATE TABLE IF NOT EXISTS \"Documentos\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"tutorado_id\" INTEGER NOT NULL,")
           .append(" \"ciclo_escolar_id\" INTEGER,")
           .append(" \"doc_tipo\" TEXT,")
           .append(" \"ruta\" TEXT NOT NULL,")
           .append(" \"nombre_original\" TEXT,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"ciclo_escolar_id\") REFERENCES \"Periodo\"(\"id\"),")
           .append(" FOREIGN KEY(\"tutorado_id\") REFERENCES \"Tutorados\"(\"id\") ON DELETE CASCADE);");
           
        sql.append("CREATE TABLE IF NOT EXISTS \"Reportes\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"tutor_id\" INTEGER NOT NULL,")
           .append(" \"tutorado_id\" INTEGER NOT NULL,")
           .append(" \"fecha_creacion\" TEXT DEFAULT CURRENT_TIMESTAMP,")
           .append(" \"cuerpo_reporte\" TEXT,")
           .append(" \"eliminado\" INTEGER DEFAULT 0,")
           .append(" FOREIGN KEY(\"tutor_id\") REFERENCES \"Tutor\"(\"id\"),")
           .append(" FOREIGN KEY(\"tutorado_id\") REFERENCES \"Tutorados\"(\"id\"));");

        sql.append("CREATE TABLE IF NOT EXISTS \"HistorialCambios\" (")
           .append(" \"id\" INTEGER PRIMARY KEY AUTOINCREMENT,")
           .append(" \"tabla_nombre\" TEXT NOT NULL,")
           .append(" \"id_valor_modificado\" INTEGER NOT NULL,")
           .append(" \"accion\" TEXT CHECK(\"accion\" IN ('INSERT', 'UPDATE', 'DELETE')),")
           .append(" \"valor_antiguo\" TEXT,")
           .append(" \"nuevo_valor\" TEXT,")
           .append(" \"fecha_cambio\" TEXT DEFAULT CURRENT_TIMESTAMP,")
           .append(" \"motivo_cambio\" TEXT);");

        sql.append("COMMIT;");

        try (Statement stmt = conectar.createStatement()) {
            stmt.executeUpdate(sql.toString());
            // System.out.println("Tablas creadas/verificadas correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
            try {
                // Si falla, intentamos rollback por seguridad
                conectar.rollback(); 
            } catch (SQLException ex) {
                // Ignorar error de rollback si no había transacción activa
            }
        }
    }

    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("Se cerro la db"); 
           }
        } catch (Exception e) {
            System.out.println("No se cerro la db correctamente" + e.toString());
        }
    }
}

