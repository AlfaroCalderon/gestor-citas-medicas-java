package modelo.persona;

public class Paciente extends Persona {
    private Long id;
    private String numeroExpediente;
    
    public Paciente() {
        super();
    }

    public Paciente(Long id, String documentoIdentidad, String nombres, String apellidos, String correo, String telefono, String direccion, String numeroExpediente) {
        super(documentoIdentidad, nombres, apellidos, correo, telefono, direccion);
        setId(id);
        setNumeroExpediente(numeroExpediente);
    }

    @Override
    public String getRolDescriptivo() {
        return "Paciente";
    }

    public Long getId() { return id; }
    public void setId(Long id) { 
        if(id == null || id <= 0) throw new IllegalArgumentException("ID del paciente debe ser un número positivo");
        this.id = id;
    }

    public String getNumeroExpediente() { return numeroExpediente; }
    public void setNumeroExpediente(String numeroExpediente) { 
        if (numeroExpediente == null || numeroExpediente.trim().isEmpty()) {
            throw new IllegalArgumentException("El número del expediente no puede ser nulo o vacío");
        }
        this.numeroExpediente = numeroExpediente.trim();
    }

    @Override
    public String toString() {
        return "Expediente N° " + numeroExpediente + " ("+ getNombreCompleto() +")";
    }
}
