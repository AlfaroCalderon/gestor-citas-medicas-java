public class Paciente extends Persona {
    public Paciente() {
        super();
    }

    public Paciente(String documentoIdentidad, String nombres, String apellidos, String correo, String telefono, String direccion) {
        super(documentoIdentidad, nombres, apellidos, correo, telefono, direccion);
    }

    @Override
    public String getRolDescriptivo() {
        return "Paciente";
    }
}
