public class Cita {

    private Long id;
    private AgendaMedica agenda;
    private Expediente expediente;
    private int orden;
    private EstadoCita estado;
    private Prioridad prioridad;
    private TipoCita tipo;
    private Cita citaOrigen;
    private boolean confirmada;

    public Cita() {
    }

    public Cita(AgendaMedica agenda, Expediente expediente, Prioridad prioridad, TipoCita tipo) {
        if (agenda == null) {
            throw new IllegalArgumentException("La agenda médica es obligatoria para la cita");
        }
        this.agenda = agenda;
        this.expediente = expediente;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.estado = EstadoCita.PROGRAMADA;
    }

    public Cita(AgendaMedica agenda, Expediente expediente, Prioridad prioridad, TipoCita tipo, Cita citaOrigen) {
        this(agenda, expediente, prioridad, tipo);
        this.citaOrigen = citaOrigen;
    }

    // --- Getters y Setters ---

    public Long getId() { return id; }

    public AgendaMedica getAgenda() { return agenda; }

    public Expediente getExpediente() { return expediente; }
    public void setExpediente(Expediente expediente) { this.expediente = expediente; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public EstadoCita getEstado() { return estado; }
    public void setEstado(EstadoCita estado) { this.estado = estado; }

    public Prioridad getPrioridad() { return prioridad; }
    public void setPrioridad(Prioridad prioridad) { this.prioridad = prioridad; }

    public TipoCita getTipo() { return tipo; }
    public TipoCita getTipoCita() { return tipo; }
    public void setTipo(TipoCita tipo) { this.tipo = tipo; }
    public void setTipoCita(TipoCita tipo) { this.tipo = tipo; }

    public Cita getCitaOrigen() { return citaOrigen; }
    public void setCitaOrigen(Cita citaOrigen) { this.citaOrigen = citaOrigen; }

    public boolean isConfirmada() { return confirmada; }
    public void setConfirmada(boolean confirmada) { this.confirmada = confirmada; }
}
