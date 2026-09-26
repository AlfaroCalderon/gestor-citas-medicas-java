package modelo.establecimiento;

import modelo.establecimiento.EstadoEstablecimiento; //error de package preguntar a elmer 
import modelo.establecimiento.TipoEstablecimiento; //error de package preguntar a elmer
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Establecimiento {

    // ATRIBUTOS

    private Long id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private TipoEstablecimiento tipo;
    private EstadoEstablecimiento estado;
    private List<String> especialidades; // Especialidades que ofrece, preguntar si tendria logica

    // CONSTRUCTORES

    public Establecimiento() {
        this.especialidades = new ArrayList<>();
        this.estado = EstadoEstablecimiento.ACTIVO;
    }

    public Establecimiento(Long id, String codigo, String nombre, String direccion,
            String telefono, String correo, TipoEstablecimiento tipo) {
        this();
        setId(id);
        setCodigo(codigo);
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
        setTipo(tipo);
    }

    // GETTERS Y SETTERS CON VALIDACIONES

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del establecimiento debe ser un número positivo");
        }
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = validarTexto(codigo, "El código del establecimiento no puede ser nulo o vacío");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre del establecimiento no puede ser nulo o vacío");
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = validarTexto(direccion, "La dirección no puede ser nula o vacía");
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        // El teléfono puede ser opcional, pero si se ingresa debe ser válido
        if (telefono != null && !telefono.trim().isEmpty()) {
            if (!telefono.matches("\\+?[0-9\\s\\-()]{7,20}")) {
                throw new IllegalArgumentException("Formato de teléfono inválido");
            }
        }
        this.telefono = telefono != null ? telefono.trim() : null;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && !correo.trim().isEmpty()) {
            if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                throw new IllegalArgumentException("Formato de correo electrónico inválido");
            }
        }
        this.correo = correo != null ? correo.trim().toLowerCase() : null;
    }

    public TipoEstablecimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstablecimiento tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de establecimiento no puede ser nulo");
        }
        this.tipo = tipo;
    }

    public EstadoEstablecimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEstablecimiento estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
        this.estado = estado;
    }

    // GESTI0N DE ESPECIALIDADES

    public List<String> getEspecialidades() {
        return Collections.unmodifiableList(especialidades);
    }

    public void agregarEspecialidad(String especialidad) {
        String esp = validarTexto(especialidad, "La especialidad no puede ser nula o vacía");
        if (!especialidades.contains(esp)) {
            especialidades.add(esp);
        }
    }

    public void eliminarEspecialidad(String especialidad) {
        especialidades.remove(especialidad);
    }

    public boolean ofreceEspecialidad(String especialidad) {
        return especialidades.contains(especialidad);
    }

    // METODOS AUXILIARES

    private static String validarTexto(String valor, String mensaje) {
        if (Objects.isNull(valor) || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    public boolean estaActivo() {
        return this.estado == EstadoEstablecimiento.ACTIVO;
    }

    // CREANDO HASH

    @Override
    public int hashCode() {
        // El código único del establecimiento es su identificador natural, preguntar a
        // elmer si cambia
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Establecimiento that = (Establecimiento) obj;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public String toString() {
        return String.format("Establecimiento{id=%d, codigo='%s', nombre='%s', tipo=%s, estado=%s}",
                id, codigo, nombre, tipo, estado);
    }
}