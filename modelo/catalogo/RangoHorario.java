import java.time.LocalTime;

public class RangoHorario {

    private Long id;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public RangoHorario() {
    }

    public RangoHorario(Long id, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() { return id; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }
}
