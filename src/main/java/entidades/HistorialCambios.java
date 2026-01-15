package entidades;

public class HistorialCambios {

    private int id;
    private String tablaNombre;
    private int idValorModificado;
    private String accion; // INSERT, UPDATE, DELETE
    private String valorAntiguo;
    private String nuevoValor;
    private String fechaCambio;
    private String motivoCambio;

    // Constructor vacío
    public HistorialCambios() {
    }

    // Constructor completo
    public HistorialCambios(int id, String tablaNombre, int idValorModificado,
            String accion, String valorAntiguo, String nuevoValor,
            String fechaCambio, String motivoCambio) {

        this.id = id;
        this.tablaNombre = tablaNombre;
        this.idValorModificado = idValorModificado;
        this.accion = accion;
        this.valorAntiguo = valorAntiguo;
        this.nuevoValor = nuevoValor;
        this.fechaCambio = fechaCambio;
        this.motivoCambio = motivoCambio;
    }

    // Constructor para INSERT (sin id ni fecha)
    public HistorialCambios(String tablaNombre, int idValorModificado,
            String accion, String valorAntiguo, String nuevoValor,
            String motivoCambio) {

        this.tablaNombre = tablaNombre;
        this.idValorModificado = idValorModificado;
        this.accion = accion;
        this.valorAntiguo = valorAntiguo;
        this.nuevoValor = nuevoValor;
        this.motivoCambio = motivoCambio;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTablaNombre() {
        return tablaNombre;
    }

    public void setTablaNombre(String tablaNombre) {
        this.tablaNombre = tablaNombre;
    }

    public int getIdValorModificado() {
        return idValorModificado;
    }

    public void setIdValorModificado(int idValorModificado) {
        this.idValorModificado = idValorModificado;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getValorAntiguo() {
        return valorAntiguo;
    }

    public void setValorAntiguo(String valorAntiguo) {
        this.valorAntiguo = valorAntiguo;
    }

    public String getNuevoValor() {
        return nuevoValor;
    }

    public void setNuevoValor(String nuevoValor) {
        this.nuevoValor = nuevoValor;
    }

    public String getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(String fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }
}
