package sv.gob.salud.CitasService.modelos.entidades;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import sv.gob.salud.CitasService.modelos.enums.Genero;

public class Empleado extends Persona{
 private String jvpm;
 private Set<Especialidad> especialidades = new LinkedHashSet<>();
 private List<AgendaMedica> agendas = new ArrayList<>();

 public Empleado( String jvpm, Set<Especialidad> especialidades, List<AgendaMedica> agendas, String documentoidentidad, String nombre, String apellido, Genero genero, LocalDate fechaNacimiento, String numeroTelefono, String correoElectronico) {
   super(documentoidentidad, nombre, apellido, genero, fechaNacimiento, numeroTelefono, correoElectronico);
   this.jvpm = jvpm;
   this.especialidades = especialidades;
   this.agendas = agendas;
 }
}
