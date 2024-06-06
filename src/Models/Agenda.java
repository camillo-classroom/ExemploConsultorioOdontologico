package Models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agenda {
    public void Agendar(AgendaCompromisso compromisso) throws Exception {
        if (compromisso.getDataHoraInicio().isBefore(LocalDateTime.now())) {
            throw new Exception("Não é possível agendar um compromisso em uma data e hora passada.");
        }

        for (AgendaCompromisso comp: compromissosAgendados) {
            if (comp.ColideCom(compromisso)) {
                throw new Exception("Este agendamento colide com outro agendamento na mesma data.");
            }
        }

        compromissosAgendados.add(compromisso);
    }

    public void Concluir(AgendaCompromisso compromisso) throws Exception {
        int i;

        if (!compromissosAgendados.contains(compromisso)) {
            throw new Exception("O compromisso informado não está agendado.");
        }

        compromissosAgendados.remove(compromisso);
        compromissosConcluidos.add(compromisso);
    }

    private ArrayList<AgendaCompromisso> compromissosAgendados = new ArrayList<AgendaCompromisso>();
    private ArrayList<AgendaCompromisso> compromissosConcluidos = new ArrayList<AgendaCompromisso>();

    public AgendaCompromisso[] getCompromissosAgendados() {
        AgendaCompromisso[] retorno = new AgendaCompromisso[compromissosAgendados.size()];
        return compromissosAgendados.toArray(retorno);
    }

    public AgendaCompromisso[] getCompromissosConcluidos() {
        AgendaCompromisso[] retorno = new AgendaCompromisso[compromissosAgendados.size()];
        return compromissosAgendados.toArray(retorno);
    }
}
