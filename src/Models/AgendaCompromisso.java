package Models;

import java.time.LocalDateTime;

public abstract class AgendaCompromisso {
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    public abstract String getDescricao();

    public boolean ColideCom(AgendaCompromisso outro) {
        return !((dataHoraInicio.isBefore(outro.getDataHoraInicio()) && dataHoraFim.isBefore(outro.getDataHoraFim())) || (dataHoraInicio.isAfter(outro.getDataHoraInicio()) && dataHoraFim.isAfter(outro.getDataHoraFim())));
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }
}
