package modelo.persona;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import modelo.agenda.AgendaMedica;
import modelo.catalogo.Especialidad;

public class Empleado extends Persona {

    private String jvpm;
    private Set<Especialidad> especialidades = new LinkedHashSet<>();
    private List<AgendaMedica> agendas = new ArrayList<>();

    public Empleado(String documentoIdentidad, String nombres, String apellidos,
                    String jvpm, Set<Especialidad> especialidades) {
        super(documentoIdentidad, nombres, apellidos);
        this.jvpm = jvpm;
        if (especialidades != null) {
            this.especialidades.addAll(especialidades);
        }
    }

    @Override
    public String getRolDescriptivo() {
        return "Profesional de salud - General";
    }

    // --- Getters y Setters ---
    public String getJvpm() { return jvpm; }
    public void setJvpm(String jvpm) { this.jvpm = jvpm; }

    public Set<Especialidad> getEspecialidades() { return especialidades; }
    public void setEspecialidades(Set<Especialidad> especialidades) {
        this.especialidades = especialidades != null ? especialidades : new LinkedHashSet<>();
    }

    public List<AgendaMedica> getAgendas() { return agendas; }
    public void setAgendas(List<AgendaMedica> agendas) {
        this.agendas = agendas != null ? agendas : new ArrayList<>();
    }
}
