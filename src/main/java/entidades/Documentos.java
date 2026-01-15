package entidades;

public class Documentos {

    private int id;
    private int tutoradoId;
    private int cicloEscolarId;
    private String docTipo;
    private String ruta;
    private String nombreOriginal;
    private boolean eliminado;

    public Documentos() {}

    public Documentos(int id, int tutoradoId, int cicloEscolarId, String docTipo,
                     String ruta, String nombreOriginal, boolean eliminado) {
        this.id = id;
        this.tutoradoId = tutoradoId;
        this.cicloEscolarId = cicloEscolarId;
        this.docTipo = docTipo;
        this.ruta = ruta;
        this.nombreOriginal = nombreOriginal;
        this.eliminado = eliminado;
    }
//Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTutoradoId() { return tutoradoId; }
    public void setTutoradoId(int tutoradoId) { this.tutoradoId = tutoradoId; }

    public int getCicloEscolarId() { return cicloEscolarId; }
    public void setCicloEscolarId(int cicloEscolarId) { this.cicloEscolarId = cicloEscolarId; }

    public String getDocTipo() { return docTipo; }
    public void setDocTipo(String docTipo) { this.docTipo = docTipo; }

    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }

    public String getNombreOriginal() { return nombreOriginal; }
    public void setNombreOriginal(String nombreOriginal) { this.nombreOriginal = nombreOriginal; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }
}
