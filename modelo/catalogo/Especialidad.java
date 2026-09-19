package modelo.catalogo;

public class Especialidad {

    private Long id;
    private String nombre;

    public Especialidad() {
    }

    public Especialidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return nombre != null ? nombre : "Especialidad sin nombre";
    }
}
