package entidades;

public class Tutorados {

    private int id;
    private int userId;
    private Integer tutorId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;
    private String carrera;
    private String status;
    private String telefono;
    private String telefonoEmergencia;
    private String domicilio;
    private String fechaInscripcion;
    private boolean afis;
    private double promedioGeneral;
    private boolean eliminado;
//Constructores
    public Tutorados() {}

    public Tutorados(int id, int userId, Integer tutorId, String nombre,
                    String apellidoPaterno, String apellidoMaterno, String matricula,
                    String carrera, String status, String telefono,
                    String telefonoEmergencia, String domicilio, String fechaInscripcion,
                    boolean afis, double promedioGeneral, boolean eliminado) {
        this.id = id;
        this.userId = userId;
        this.tutorId = tutorId;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.carrera = carrera;
        this.status = status;
        this.telefono = telefono;
        this.telefonoEmergencia = telefonoEmergencia;
        this.domicilio = domicilio;
        this.fechaInscripcion = fechaInscripcion;
        this.afis = afis;
        this.promedioGeneral = promedioGeneral;
        this.eliminado = eliminado;
    }
//Setters y Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean isAfis() {
        return afis;
    }

    public void setAfis(boolean afis) {
        this.afis = afis;
    }

    public double getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(double promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
}
