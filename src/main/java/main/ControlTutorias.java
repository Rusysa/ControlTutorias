/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import db.conexion;
import db.crearDb;
import interfaz.AmainFrame.mainFrameForm;

/**
 *
 * @author rudy
 */
public class ControlTutorias {

    public static void main(String[] args) {
    
        javax.swing.SwingUtilities.invokeLater(() -> {
            new mainFrameForm().setVisible(true);
        });
     
        crearDb creardb = new crearDb();
        
      /*  conexion conexion = new conexion();
        conexion.establecerConexion();
        */
        //La clase de "creardb" tiene el metodo de establecer conexion que ya dentro llama al metodo que crea las tablas
        creardb.establecerConexion();
        creardb.cerrarConexion();
        
        
        
    }
}
