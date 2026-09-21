package modelo.expediente;

import modelo.persona.Paciente;

public class Expediente {

    private Long id;
    private String numero;
    private Paciente paciente;

    public Expediente() {
    }

    public Expediente(Long id, String numero, Paciente paciente) {
        setId(id);
        setNumero(numero);
        setPaciente(paciente);
    }

    public Long getId() { return id; }
    public void setId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del expediente debe ser positivo");
        }
        this.id = id;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El número del expediente no puede ser nulo o vacío");
        }
        this.numero = numero.trim();
    }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente del expediente es obligatorio");
        }
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Expediente N° " + numero + " (" + (paciente != null ? paciente.getNombreCompleto() : "") + ")";
    }
}
