package sv.gob.salud.CitasService.modelos.entidades;
import java.time.LocalDate;

import sv.gob.salud.CitasService.modelos.enums.Genero;
import sv.gob.salud.CitasService.modelos.enums.Roles;

public class Usuario extends Persona {
    private Long id;
    private String nombreUsuario;
    private Roles rol; 

    public Usuario(Long id, String nombreUsuario, Roles rol, String documentoidentidad, String nombre, String apellido, Genero genero, LocalDate fechaNacimiento, String numeroTelefono, String correoElectronico) {
        super(documentoidentidad, nombre, apellido, genero, fechaNacimiento, numeroTelefono, correoElectronico);
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
    }
}
