package Models;

public class Dentista extends Usuario {
    private Agenda agenda;

    public  Agenda getAgenda() {
        if (agenda == null) {
            agenda = new Agenda();
        }

        return agenda;
    }

    private String numeroCro;

    public String getNumeroCro() {
        return numeroCro;
    }

    public void setNumeroCro(String numeroCro) {
        this.numeroCro = numeroCro;
    }
}
