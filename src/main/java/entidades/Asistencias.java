package entidades;

public class Asistencias {

    private int id;
    private int sesionId;
    private int inscripcionId;
    private String estado;
    private boolean eliminado;

    public Asistencias() {}

    public Asistencias(int id, int sesionId, int inscripcionId, String estado, boolean eliminado) {
        this.id = id;
        this.sesionId = sesionId;
        this.inscripcionId = inscripcionId;
        this.estado = estado;
        this.eliminado = eliminado;
    }
//Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getSesionId() { return sesionId; }
    public void setSesionId(int sesionId) { this.sesionId = sesionId; }

    public int getInscripcionId() { return inscripcionId; }
    public void setInscripcionId(int inscripcionId) { this.inscripcionId = inscripcionId; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }
}
