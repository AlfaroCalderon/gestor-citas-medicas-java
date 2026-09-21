package modelo.cita;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import modelo.agenda.AgendaMedica;
import modelo.catalogo.Prioridad;
import modelo.catalogo.TipoCita;
import modelo.persona.Paciente;

public class CitaVirtual extends Cita {

    private static final String MODALIDAD = "Virtual";
    private static final BigDecimal FACTOR_TARIFA = new BigDecimal("0.80");

    private String plataforma;
    private String enlaceReunion;

    public CitaVirtual(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo,
                       String plataforma, String enlaceReunion) {
        super(agenda, paciente, prioridad, tipo);
        setPlataforma(plataforma);
        setEnlaceReunion(enlaceReunion);
    }

    public CitaVirtual(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo,
                       String plataforma, String enlaceReunion, Cita citaOrigen) {
        this(agenda, paciente, prioridad, tipo, plataforma, enlaceReunion);
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
        return "Conéctese a la sala " + (plataforma != null ? plataforma : "de telemedicina")
                + " 10 minutos antes de su hora. Verifique micrófono, cámara y conexión a internet.";
    }


    public String getPlataforma() { return plataforma; }

    public final void setPlataforma(String plataforma) {
        if (Objects.isNull(plataforma) || plataforma.trim().isEmpty()) {
            throw new IllegalArgumentException("La plataforma no puede estar vacía o ser null");
        }
        this.plataforma = plataforma;
    }

    public String getEnlaceReunion() { return enlaceReunion; }

    public final void setEnlaceReunion(String enlaceReunion) {
        if (Objects.isNull(enlaceReunion) || !enlaceReunion.trim().isEmpty()
                || !enlaceReunion.toLowerCase().startsWith("https://")) {
            throw new IllegalArgumentException("El enlace de reunión debe iniciar con https://");
        }
        this.enlaceReunion = enlaceReunion;
    }
}
