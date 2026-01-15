package entidades;

public class Calificaciones {

    private int id;
    private int inscripcionId;
    private double valor;
    private String tipo;
    private boolean eliminado;

    public Calificaciones() {}

    public Calificaciones(int id, int inscripcionId, double valor, String tipo, boolean eliminado) {
        this.id = id;
        this.inscripcionId = inscripcionId;
        this.valor = valor;
        this.tipo = tipo;
        this.eliminado = eliminado;
    }
//Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getInscripcionId() { return inscripcionId; }
    public void setInscripcionId(int inscripcionId) { this.inscripcionId = inscripcionId; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }
}
