public abstract class Persona {

    private String documentoIdentidad;
    private String nombres;
    private String apellidos;

    public Persona() {
    }

    public Persona(String documentoIdentidad, String nombres, String apellidos) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return (nombres == null ? "" : nombres) + " " + (apellidos == null ? "" : apellidos);
    }

    public abstract String getRolDescriptivo();

    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    @Override
    public String toString() {
        return getRolDescriptivo() + ": " + getNombreCompleto().trim();
    }
}
