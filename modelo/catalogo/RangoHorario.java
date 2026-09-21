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
       setId(id);
       setHoraInicio(horaInicio);
       setHoraFin(horaFin);
    }

    public Long getId() { return id; }
    public void setId(Long id){
        if(id == null || id <= 0 ) throw new IllegalArgumentException("ID del horario laboral debe ser un número positivo");
        this.id = id;
    }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) {
    if (horaInicio == null) throw new IllegalArgumentException("La hora de inicio no puede ser nula");
    if (horaFin != null && !horaInicio.isBefore(horaFin))throw new IllegalArgumentException("La hora de inicio debe ser anterior a la hora de fin");
    this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) {
    if (horaFin == null) throw new IllegalArgumentException("La hora de fin no puede ser nula");
    if (horaInicio != null && !horaFin.isAfter(horaInicio)) throw new IllegalArgumentException("La hora de fin debe ser posterior a la hora de inicio");
    this.horaFin = horaFin;
}


   


}
