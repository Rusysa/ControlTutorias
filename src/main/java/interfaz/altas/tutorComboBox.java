/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.altas;

/**
 *
 * @author rudy
 */
public class tutorComboBox {
    private int id;
    private String nombreCompleto;

    public tutorComboBox(int id, String nombre) {
        this.id = id;
        this.nombreCompleto = nombre;
    }

    public int getId() {
        return id;
    }

    // Esto es lo que el ComboBox mostrará al usuario
    @Override
    public String toString() {
        return nombreCompleto;
    }
}
