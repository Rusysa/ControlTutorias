package entidades;

public class Sesiones{

    private int id;
    private int periodoId;
    private int tutorId;
    private String tipoSesion;
    private String fecha;
    private String tema;
    private String comentarios;
    private boolean eliminado;

    public Sesiones() {}

    public Sesiones(int id, int periodoId, int tutorId, String tipoSesion,
                  String fecha, String tema, String comentarios, boolean eliminado) {
        this.id = id;
        this.periodoId = periodoId;
        this.tutorId = tutorId;
        this.tipoSesion = tipoSesion;
        this.fecha = fecha;
        this.tema = tema;
        this.comentarios = comentarios;
        this.eliminado = eliminado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        this.periodoId = periodoId;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public String getTipoSesion() {
        return tipoSesion;
    }

    public void setTipoSesion(String tipoSesion) {
        this.tipoSesion = tipoSesion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
}
