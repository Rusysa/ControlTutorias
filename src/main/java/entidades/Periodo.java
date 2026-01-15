package entidades;

public class Periodo {

    private int id;
    private String ciclo;
    private String fechaInicio;
    private String fechaFin;
    private boolean esActivo;
    private boolean eliminado;

    public Periodo() {}

    public Periodo(int id, String ciclo, String fechaInicio, String fechaFin,
                   boolean esActivo, boolean eliminado) {
        this.id = id;
        this.ciclo = ciclo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esActivo = esActivo;
        this.eliminado = eliminado;
    }
    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCiclo() { return ciclo; }
    public void setCiclo(String ciclo) { this.ciclo = ciclo; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    public boolean isEsActivo() { return esActivo; }
    public void setEsActivo(boolean esActivo) { this.esActivo = esActivo; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }
}
