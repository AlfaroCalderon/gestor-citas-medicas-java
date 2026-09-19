package modelo.expediente;

import modelo.persona.Paciente;

public class Expediente {

    private Long id;
    private String numero;
    private Paciente paciente;

    public Expediente() {
    }

    public Expediente(Long id, String numero, Paciente paciente) {
        this.id = id;
        this.numero = numero;
        this.paciente = paciente;
    }

    public Long getId() { return id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    @Override
    public String toString() {
        return "Expediente N° " + numero + " (" + (paciente != null ? paciente.getNombreCompleto() : "") + ")";
    }
}
