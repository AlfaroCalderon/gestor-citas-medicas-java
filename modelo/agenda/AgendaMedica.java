package modelo.agenda;

import excepcion.DatosCitaInvalidosException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private Set<Cita> citas = new HashSet<>();

    public AgendaMedica() {
    }

    public AgendaMedica(Long id, Empleado medico, Especialidad especialidad, LocalDate fecha,
                        RangoHorario rangoHorario, int cupoMaximo) {
        this.id = id;
        setMedico(medico);
        setEspecialidad(especialidad);
        setFecha(fecha);
        setRangoHorario(rangoHorario);
        setCupoMaximo(cupoMaximo);
    }

    // --- Getters y Setters ---
    public Long getId() { return id; }

    public Empleado getMedico() { return medico; }
    public void setMedico(Empleado medico) { 
        if(Objects.isNull(medico)) {
            throw new DatosCitaInvalidosException("El médico no puede ser nulo");
        }
        this.medico = medico; 
    }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { 
        if(Objects.isNull(especialidad)) {
            throw new DatosCitaInvalidosException("La especialidad no puede ser nula");
        }
        this.especialidad = especialidad; 
    }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { 
        if(Objects.isNull(fecha)) {
            throw new DatosCitaInvalidosException("La fecha no puede ser nula");
        }
        this.fecha = fecha; 
    }

    public RangoHorario getRangoHorario() { return rangoHorario; }
    public void setRangoHorario(RangoHorario rangoHorario) { 
        if(Objects.isNull(rangoHorario)) {
            throw new DatosCitaInvalidosException("El rango horario no puede ser nulo");
        }
        this.rangoHorario = rangoHorario; 
    }

    public int getCupoMaximo() { return cupoMaximo; }

    public final void setCupoMaximo(int cupoMaximo) {
        if (cupoMaximo < 1) {
            throw new DatosCitaInvalidosException("El cupo máximo de la agenda debe ser al menos 1");
        }
        this.cupoMaximo = cupoMaximo;
    }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    public Set<Cita> getCitas() { return citas; }
    public void setCitas(Cita cita) {
        if (cita == null) throw new DatosCitaInvalidosException("La cita no puede ser nula");
        if (!isActiva()) throw new DatosCitaInvalidosException("La agenda no está activa");

        if (cupoMaximo > 0 && citas.size() >= cupoMaximo) {
            throw new DatosCitaInvalidosException("Cupo máximo alcanzado");
        }

        this.citas.add(cita);
    }

    public int getCantidadCitas() {
        return citas.size();
    }

}
