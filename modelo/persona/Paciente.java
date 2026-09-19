package modelo.persona;

public class Paciente extends Persona {

    private String telefono;
    private String correoElectronico;

    public Paciente() {
        super();
    }

    public Paciente(String documentoIdentidad, String nombres, String apellidos) {
        super(documentoIdentidad, nombres, apellidos);
    }

    public Paciente(String documentoIdentidad, String nombres, String apellidos,
                    String telefono, String correoElectronico) {
        this(documentoIdentidad, nombres, apellidos);
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String getRolDescriptivo() {
        return "Paciente";
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
}
