package modelo.cita;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import modelo.agenda.AgendaMedica;
import modelo.catalogo.Prioridad;
import modelo.catalogo.TipoCita;
import modelo.persona.Paciente;

public class CitaDomiciliaria extends Cita {

    private static final String MODALIDAD = "Domiciliaria";
    private static final BigDecimal FACTOR_TARIFA = new BigDecimal("1.50");

    private String direccionVisita;
    private String referenciaUbicacion;

    public CitaDomiciliaria(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo,
                            String direccionVisita) {
        this(agenda, paciente, prioridad, tipo, direccionVisita, null);
    }

    public CitaDomiciliaria(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo,
                            String direccionVisita, String referenciaUbicacion) {
        super(agenda, paciente, prioridad, tipo);
        setDireccionVisita(direccionVisita);
        this.referenciaUbicacion = referenciaUbicacion;
    }

    public CitaDomiciliaria(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo,
                            String direccionVisita, String referenciaUbicacion, Cita citaOrigen) {
        this(agenda, paciente, prioridad, tipo, direccionVisita, referenciaUbicacion);
        setCitaOrigen(citaOrigen);
    }

    @Override
    public String getModalidad() {
        return MODALIDAD;
    }

    @Override
    public BigDecimal calcularCosto(BigDecimal tarifaBase) {
        Objects.requireNonNull(tarifaBase, "La tarifa base es obligatoria");
        return tarifaBase.multiply(FACTOR_TARIFA).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String obtenerIndicaciones() {
        return "El profesional se trasladara a " + getDireccionCompleta()
                + ". Tenga a la mano su documento de identidad y los estudios previos.";
    }

    public String getDireccionCompleta() {
        return direccionVisita + (referenciaUbicacion != null && !referenciaUbicacion.trim().isEmpty()
                ? " (Ref: " + referenciaUbicacion + ")"
                : "");
    }

    public String getDireccionVisita() { return direccionVisita; }

    public final void setDireccionVisita(String direccionVisita) {
        if (direccionVisita == null || direccionVisita.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección de visita es obligatoria en una cita domiciliaria");
        }
        this.direccionVisita = direccionVisita;
    }

    public String getReferenciaUbicacion() { return referenciaUbicacion; }

    public void setReferenciaUbicacion(String referenciaUbicacion) { this.referenciaUbicacion = referenciaUbicacion; }
}
