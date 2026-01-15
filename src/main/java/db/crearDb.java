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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class crearDb {

    private Connection conectar = null;
    // Definimos la ruta: src/main/java/db/ (Multiplataforma)
    private final String rutaCarpeta = "src" + File.separator + "main" + File.separator + "java" + File.separator + "db";
    private final String archivoBD = "dtabase.db";
    // Nombre del archivo SQL nuevo
    private final String archivoSQL = "dbscript.sql"; 
    
    // Cadena de conexión
    private final String cadena = "jdbc:sqlite:" + System.getProperty("user.dir") 
                                  + File.separator + rutaCarpeta 
                                  + File.separator + archivoBD;

    // LA FUNCION DE ESTABLECER CONEXION TAMBIEN TIENE LA FUNCION PARA CREAR LAS TABLAS
    public Connection establecerConexion() {
        try {
            // 1. Verificar y crear carpetas si no existen
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    System.out.println("Carpeta creada.");
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

            // 5. AQUI SE CREAN LAS TABLAS LEYENDO EL ARCHIVO
            crearTablas();

            System.out.println("Conexion a la base de datos exitosa.");

        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.toString());
        }
        return conectar;
    }

    private void crearTablas() {
        // Construimos la ruta completa al archivo SQL
        String rutaScript = System.getProperty("user.dir") 
                            + File.separator + rutaCarpeta 
                            + File.separator + archivoSQL;

        try {
            // Leemos todo el contenido del archivo a un String
            // Nota: Esto funciona en Java 7 en adelante
            String sqlContent = new String(Files.readAllBytes(Paths.get(rutaScript)));
            
            // SQLite ejecuta una sentencia a la vez, separamos por ";"
            String[] sentencias = sqlContent.split(";");

            try (Statement stmt = conectar.createStatement()) {
                for (String sentencia : sentencias) {
                    // Limpiamos espacios y evitamos ejecutar líneas vacías
                    if (!sentencia.trim().isEmpty()) {
                        stmt.execute(sentencia);
                    }
                }
                // Si quieres confirmar que leyó el script, descomenta la siguiente linea:
                // System.out.println("Tablas verificadas desde schema.sql");
            }
            
        } catch (IOException e) {
            System.out.println("Error CRITICO: No se encontró el archivo SQL en: " + rutaScript);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error SQL al crear tablas: " + e.getMessage());
            try {
                if (conectar != null) conectar.rollback(); 
            } catch (SQLException ex) { }
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