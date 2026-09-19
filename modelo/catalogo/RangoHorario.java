package modelo.catalogo;

import java.time.LocalTime;
import java.util.Objects;

public class RangoHorario {

    private Long id;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public RangoHorario() {
    }

    public RangoHorario(Long id, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
        validarCoherencia();
    }

    private void validarCoherencia() {
        if (horaInicio != null && horaFin != null && !horaInicio.isBefore(horaFin)) {
            throw new IllegalArgumentException("La hora de inicio (" + horaInicio
                    + ") debe ser anterior a la hora de fin (" + horaFin + ")");
        }
    }

    public Long getId() { return id; }

    public LocalTime getHoraInicio() { return horaInicio; }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = Objects.requireNonNull(horaInicio, "La hora de inicio es obligatoria");
        validarCoherencia();
    }

    public LocalTime getHoraFin() { return horaFin; }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = Objects.requireNonNull(horaFin, "La hora de fin es obligatoria");
        validarCoherencia();
    }

    @Override
    public String toString() {
        return horaInicio + " - " + horaFin;
    }
}
