package modelo.cita;

import java.math.BigDecimal;
import java.util.Objects;

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
        if (Objects.isNull(agenda)) {
            throw new IllegalArgumentException("La agenda médica es obligatoria para la cita");
        }
        if (Objects.isNull(paciente)) {
            throw new IllegalArgumentException("El paciente es obligatorio para la cita");
        }
        if (Objects.isNull(prioridad)) {
            throw new IllegalArgumentException("La prioridad es obligatoria para la cita");
        }
        if (Objects.isNull(tipo)) {
            throw new IllegalArgumentException("El tipo de cita es obligatorio");
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

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { 
        if (Objects.isNull(paciente)) throw new IllegalArgumentException("El paciente no puede ser null");
        this.paciente = paciente; 
    }

    public int getOrden() { return orden; }
    public void setOrden(int orden) {
        if (orden < 0) throw new IllegalArgumentException("El orden no puede ser negativo");
        this.orden = orden;
    }

    public EstadoCita getEstado() { return estado; }

    public Prioridad getPrioridad() { return prioridad; }
    public void setPrioridad(Prioridad prioridad) {
        if (Objects.isNull(prioridad)) throw new IllegalArgumentException("La prioridad no puede ser null");
        this.prioridad = prioridad;
    }

    public TipoCita getTipo() { return tipo; }
    public void setTipo(TipoCita tipo) {
        if (Objects.isNull(tipo)) throw new IllegalArgumentException("El tipo de cita no puede ser null");
        this.tipo = tipo;
    }

    public Cita getCitaOrigen() { return citaOrigen; }
    public void setCitaOrigen(Cita citaOrigen) {
        if (citaOrigen == this) {
            throw new IllegalArgumentException("Una cita no puede ser su propia cita origen");
        }
        this.citaOrigen = citaOrigen;
    }
}
