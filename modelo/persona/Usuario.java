public class Usuario extends Persona {

    private String nombreUsuario;
    private String rolSistema;

    public Usuario() {
        super();
    }

    public Usuario(String documentoIdentidad, String nombres, String apellidos,
                   String nombreUsuario, String rolSistema) {
        super(documentoIdentidad, nombres, apellidos);
        this.nombreUsuario = nombreUsuario;
        this.rolSistema = rolSistema;
    }

    @Override
    public String getRolDescriptivo() {
        return "Usuario del sistema (" + (rolSistema != null ? rolSistema : "") + ")";
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getRolSistema() { return rolSistema; }
    public void setRolSistema(String rolSistema) { this.rolSistema = rolSistema; }
}
