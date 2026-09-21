package excepcion;
public class DatosPersonaInvalidosException extends IllegalArgumentException {
    public DatosPersonaInvalidosException(String mensaje) {
        super(mensaje);
    }
}