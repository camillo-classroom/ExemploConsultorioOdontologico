package Services;

import Models.Paciente;
import State.Dados;

import java.util.ArrayList;

public class PacienteService {
    public ArrayList<Paciente> getPacientes() { return Dados.getPacientes(); }

    public void inserir(Paciente paciente) {
        Dados.getPacientes().add(paciente);
    }

    public Paciente getPacientePorEmail(String email) {
        for (Paciente usr: Dados.getPacientes()) {
            if (usr.getEmail().equals(email)) {
                return usr;
            }
        }

        return null;
    }

    public void alterar(Paciente pacienteAlterado) throws Exception {
        Paciente paciente = getPacientePorEmail(pacienteAlterado.getEmail());

        if (paciente == null)
            throw  new Exception("Não é possível alterar. Paciente não encontrado(a).");

        paciente.setNome(pacienteAlterado.getNome());
        paciente.setTelefone(pacienteAlterado.getTelefone());
    }

    public void excluir(String email) throws Exception {
        Paciente paciente = getPacientePorEmail(email);

        if (paciente == null)
            throw  new Exception("Não é possível excluir. Paciente não encontrado(a).");

        Dados.getPacientes().remove(paciente);
    }
}
