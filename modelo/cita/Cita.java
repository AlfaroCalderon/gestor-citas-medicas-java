package modelo.cita;

import java.math.BigDecimal;
import modelo.agenda.AgendaMedica;
import modelo.catalogo.EstadoCita;
import modelo.catalogo.Prioridad;
import modelo.catalogo.TipoCita;
import modelo.persona.Paciente;

public abstract class Cita {

    private Long id;
    private final AgendaMedica agenda;
    private Paciente paciente;
    private int orden;
    private EstadoCita estado;
    private Prioridad prioridad;
    private TipoCita tipo;
    private Cita citaOrigen;

    protected Cita(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo) {
        if (agenda == null) {
            throw new IllegalArgumentException("La agenda médica es obligatoria para la cita");
        }
        this.agenda = agenda;
        this.paciente = paciente;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.estado = EstadoCita.PROGRAMADA;
    }

    protected Cita(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo, Cita citaOrigen) {
        this(agenda, paciente, prioridad, tipo);
        this.citaOrigen = citaOrigen;
    }

    abstract String getModalidad();

    abstract BigDecimal calcularCosto(BigDecimal tarifaBase);

    abstract String obtenerIndicaciones();

    // --- Getters y Setters ---
    public Long getId() { return id; }

    public AgendaMedica getAgenda() { return agenda; }

    public Paciente getExpediente() { return paciente; }
    public void setExpediente(Paciente paciente) { this.paciente = paciente; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public EstadoCita getEstado() { return estado; }

    public Prioridad getPrioridad() { return prioridad; }
    public void setPrioridad(Prioridad prioridad) { this.prioridad = prioridad; }

    public TipoCita getTipo() { return tipo; }
    public void setTipo(TipoCita tipo) { this.tipo = tipo; }

    public Cita getCitaOrigen() { return citaOrigen; }
    public void setCitaOrigen(Cita citaOrigen) { this.citaOrigen = citaOrigen; }
}
