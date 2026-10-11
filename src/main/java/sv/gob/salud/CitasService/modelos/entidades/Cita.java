package sv.gob.salud.CitasService.modelos.entidades;
import  sv.gob.salud.CitasService.modelos.enums.TipoCita;
import  sv.gob.salud.CitasService.modelos.enums.EstadoCita;
import sv.gob.salud.CitasService.modelos.enums.Prioridad;

public class Cita {
    private Long id;
    private AgendaMedica agenda;
    private Expediente expediente;
    private int order;
    private EstadoCita estado;
    private Prioridad prioridad;
    private TipoCita tipo;
    private Cita citaOrigen;
}
