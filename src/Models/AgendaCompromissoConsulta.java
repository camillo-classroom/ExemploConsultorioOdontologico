package Models;

public class AgendaCompromissoConsulta extends AgendaCompromisso{
    private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String getDescricao() {
        return "Consulta: " + (paciente == null ? "" : paciente.getNome());
    }
}
