package modelo.persona;
import excepcion.DatosPersonaInvalidosException;
import java.util.Objects;

abstract class Persona {

    private String documentoIdentidad;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String direccion;

    public Persona() {
    }

    public Persona(String documentoIdentidad, String nombres, String apellidos, String correo, String telefono, String direccion) {
        this.documentoIdentidad = validarTexto(documentoIdentidad, "DUI no puede ser nulo o vacío");
        setNombres(nombres);
        setApellidos(apellidos);
        setCorreo(correo); 
        setTelefono(telefono); 
        setDireccion(direccion); 
    }   

    // --- Getters y Setters ---
    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = validarTexto(documentoIdentidad, "DUI no puede ser nulo o vacío");
    }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) {
        this.nombres = validarTexto(nombres, "Nombre no puede ser nulo o vacío");
    }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) {
        this.apellidos = validarTexto(apellidos, "Apellido no puede ser nulo o vacío");
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        this.correo = validarTexto(correo, "Correo no puede ser nulo o vacío");
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        this.telefono = validarTexto(telefono, "Teléfono no puede ser nulo o vacío");
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) {
        this.direccion = validarTexto(direccion, "Dirección no puede ser nula o vacía");
    }

    protected static String validarTexto(String valor, String mensaje) {
        if (Objects.isNull(valor) || valor.trim().isEmpty()) {
            throw new DatosPersonaInvalidosException(mensaje);
        }
        return valor.trim();
    }

    public String getNombreCompleto() {
        return (Objects.isNull(nombres) ? "" : nombres) + " " + (Objects.isNull(apellidos) ? "" : apellidos);
    }

    abstract String getRolDescriptivo();

    @Override
    public String toString() {
        return getRolDescriptivo() + ": " + getNombreCompleto().trim();
    }
}
