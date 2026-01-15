/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author rudy
 */
public class conexion {
   String rutaCarpeta = "src" + File.separator + "main" + File.separator + "java" + File.separator + "db";
   Connection conectar = null;
    String archivoBD = "dtabase.db";
    String cadena = "jdbc:sqlite:" + System.getProperty("user.dir") 
                                  + File.separator + rutaCarpeta 
                                  + File.separator + archivoBD;
    
    
        public Connection establecerConexion(){
        Connection conectar = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection(cadena);
            System.out.println("Conexion a la db exitosa");
        }catch (Exception e){
            System.out.println("Conexion Fallida" + e.toString());
            }
        return conectar;
        }
        
        public void cerrarConexion(){
            try{
                if(conectar != null){
                    conectar.close();
                }
            }catch(Exception e){
                System.out.println("No se cerro la db correctamente"+ e.toString());
            }
        }

}
