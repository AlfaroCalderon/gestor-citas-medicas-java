package modelo.cita;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import modelo.agenda.AgendaMedica;
import modelo.catalogo.Prioridad;
import modelo.catalogo.TipoCita;
import modelo.persona.Paciente;

public class CitaPresencial extends Cita {

    private static final String MODALIDAD = "Presencial";
    private static final BigDecimal FACTOR_TARIFA = BigDecimal.ONE;

    private String consultorio;

    public CitaPresencial(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo,
                        String consultorio) {
        super(agenda, paciente, prioridad, tipo);
        setConsultorio(consultorio);
    }

    public CitaPresencial(AgendaMedica agenda, Paciente paciente, Prioridad prioridad, TipoCita tipo,
                          String consultorio, Cita citaOrigen) {
        this(agenda, paciente, prioridad, tipo, consultorio);
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
        return "Presentese en " + getConsultorio() + " 15 minutos antes con su documento de identidad.";
    }


    public String getConsultorio() { return consultorio; }

    public final void setConsultorio(String consultorio) {
        if (Objects.isNull(consultorio) || consultorio.trim().isEmpty()) {
            throw new IllegalArgumentException("El consultorio no puede estar vacío");
        }
        this.consultorio = consultorio;
    }
}
