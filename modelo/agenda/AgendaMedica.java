package modelo.agenda;

import excepcion.DatosCitaInvalidosException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.catalogo.Especialidad;
import modelo.catalogo.RangoHorario;
import modelo.cita.Cita;
import modelo.persona.Empleado;

/**
 * Agenda de un profesional para una fecha y rango horario determinados.
 * Controla el cupo máximo y la disponibilidad de las citas registradas.
 */
public class AgendaMedica {

    private Long id;
    private Empleado medico;
    private Especialidad especialidad;
    private LocalDate fecha;
    private RangoHorario rangoHorario;
    private int cupoMaximo;
    private boolean activa = true;
    private List<Cita> citas = new ArrayList<>();

    public AgendaMedica() {
    }

    public AgendaMedica(Long id, Empleado medico, Especialidad especialidad, LocalDate fecha,
                        RangoHorario rangoHorario, int cupoMaximo) {
        this.id = id;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.rangoHorario = rangoHorario;
        setCupoMaximo(cupoMaximo);
    }

    // --- Getters y Setters ---
    public Long getId() { return id; }

    public Empleado getMedico() { return medico; }
    public void setMedico(Empleado medico) { this.medico = medico; }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public RangoHorario getRangoHorario() { return rangoHorario; }
    public void setRangoHorario(RangoHorario rangoHorario) { this.rangoHorario = rangoHorario; }

    public int getCupoMaximo() { return cupoMaximo; }

    public final void setCupoMaximo(int cupoMaximo) {
        if (cupoMaximo < 1) {
            throw new DatosCitaInvalidosException("El cupo máximo de la agenda debe ser al menos 1");
        }
        this.cupoMaximo = cupoMaximo;
    }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    public List<Cita> getCitas() { return citas; }
    public void setCitas(List<Cita> citas) { this.citas = citas != null ? citas : new ArrayList<>(); }

}
