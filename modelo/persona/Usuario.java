package modelo.persona;

public class Usuario extends Persona {
    private Long id;
    private String nombreUsuario;
    private String rolSistema;

    public Usuario() {
        super();
    }

    public Usuario(Long id, String documentoIdentidad, String nombres, String apellidos, String correo, String telefono, String direccion, String nombreUsuario, String rolSistema) {
        super(documentoIdentidad, nombres, apellidos, correo, telefono, direccion);
        setId(id);
        setNombreUsuario(nombreUsuario); 
        setRolSistema(rolSistema); 
    }

    @Override
    public String getRolDescriptivo() {
        return "Usuario del sistema (" + (rolSistema != null ? rolSistema : "") + ")";
    }

    public Long getId(){return id;}
    public void setId(Long id){
        if(id <= 0) {
            throw new IllegalArgumentException("ID del paciente debe ser un número positivo");
        }
        this.id = id;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { 
        this.nombreUsuario = validarTexto(nombreUsuario, "Nombre Usuario no puede ser nulo o vacío"); 
    }

    public String getRolSistema() { return rolSistema; }
    public void setRolSistema(String rolSistema) { 
         this.rolSistema = validarTexto(rolSistema, "Rol en Sistema no puede ser nulo o vacío"); 
    }
}
