package modelo.catalogo;

import java.util.Objects;

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
        if (Objects.isNull(id) || id <= 0) throw new IllegalArgumentException("El ID de la especialidad debe ser positivo");
        this.id = id;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { 
        
        this.nombre = nombre; 
    }

    @Override
    public String toString() {
        return nombre != null ? nombre : "Especialidad sin nombre";
    }
}
