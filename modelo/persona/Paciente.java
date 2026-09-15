public class Paciente extends Persona {

    public Paciente() {
        super();
    }

    public Paciente(String documentoIdentidad, String nombres, String apellidos) {
        super(documentoIdentidad, nombres, apellidos);
    }

    @Override
    public String getRolDescriptivo() {
        return "Paciente";
    }
}
