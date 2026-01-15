package entidades;

public class Reportes{

    private int id;
    private int tutorId;
    private int tutoradoId;
    private String fechaCreacion;
    private String cuerpoReporte;
    private boolean eliminado;

    //Constructores
    public Reportes() {}

    public Reportes(int id, int tutorId, int tutoradoId,
                   String fechaCreacion, String cuerpoReporte, boolean eliminado) {
        this.id = id;
        this.tutorId = tutorId;
        this.tutoradoId = tutoradoId;
        this.fechaCreacion = fechaCreacion;
        this.cuerpoReporte = cuerpoReporte;
        this.eliminado = eliminado;
    }
    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public int getTutoradoId() {
        return tutoradoId;
    }

    public void setTutoradoId(int tutoradoId) {
        this.tutoradoId = tutoradoId;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCuerpoReporte() {
        return cuerpoReporte;
    }

    public void setCuerpoReporte(String cuerpoReporte) {
        this.cuerpoReporte = cuerpoReporte;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
}
