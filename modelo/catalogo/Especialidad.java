public class Especialidad {

    private Long id;
    private String nombre;

    public Especialidad() {
    }

    public Especialidad(Long id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public Long getId() { return id; }
    public void setId(Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException("El ID de la especialidad debe ser positivo");
        this.id = id;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre de la especialidad no puede ser nulo o vacío");
        this.nombre = nombre.trim();
    }
}
