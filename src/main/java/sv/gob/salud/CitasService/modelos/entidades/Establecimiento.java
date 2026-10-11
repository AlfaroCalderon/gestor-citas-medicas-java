package sv.gob.salud.CitasService.modelos.entidades;
import  sv.gob.salud.CitasService.modelos.enums.TipoEstablecimiento;

import java.util.ArrayList;
import java.util.List;
import  sv.gob.salud.CitasService.modelos.enums.EstadoEstablecimiento;

public class Establecimiento {
    private Long id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private TipoEstablecimiento tipo;
    private EstadoEstablecimiento estado;
    private List<String> especialidades = new ArrayList<>(); // Especialidades que ofrece, preguntar si tendria logica
}
