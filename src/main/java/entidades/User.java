/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author soyge
 */
public class User {
    private int id;
    private String correo;
    private String pass;
    private String role;
    private String fechaCreacion;
    private boolean eliminado;
    
    //Constructores

    public User() {
        
    }

    public User(int id, String correo, String pass, String role, String fechaCreacion, boolean eliminado) {
        this.id = id;
        this.correo = correo;
        this.pass = pass;
        this.role = role;
        this.fechaCreacion = fechaCreacion;
        this.eliminado = eliminado;
    }
//Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
}
