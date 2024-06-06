package Views;

import Models.*;
import Services.PacienteService;
import Services.UsuarioService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class AgendaView {
    public static void apresentarMenuUsuarioLogado() {
        UsuarioService servico = new UsuarioService();

        if (servico.getUsuarioLogado() instanceof Dentista) {
            apresentarMenu((Dentista) servico.getUsuarioLogado());
        } else {
            System.out.println("O usuário corrente não é um dentista.");
        }
    }

    public static void apresentarMenu() {
        Dentista dentista = pesquisarDentista();

        if (dentista == null) {
            return;
        }

        apresentarMenu(dentista);
    }

    public static void apresentarMenu(Dentista dentista) {

        System.out.println("Agendas (escolha uma opção):");
        System.out.println(" 1 - Inserir Consulta");
        System.out.println(" 2 - Inserir Compromisso Externo");
        System.out.println(" 3 - Consultar");
        System.out.print("Opção: ");

        boolean continuar;

        do {
            continuar = false;

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    inserirConsulta(dentista);
                    break;
                case 2:
                    inserirCompromissoExterno(dentista);
                    break;
                case 3:
                    consultarAgenda(dentista);
                    break;
                default:
                    continuar = true;
            }
        } while (continuar);
    }

    private static void inserirConsulta(Dentista dentista) {
        Paciente paciente = pesquisarPaciente();

        AgendaCompromissoConsulta consulta = new AgendaCompromissoConsulta();

        consulta.setPaciente(paciente);

        leDataHora(consulta);

        try {
            dentista.getAgenda().Agendar(consulta);
            System.out.println("Agendamento de consulta efetuado com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Paciente pesquisarPaciente() {
        Scanner sc = new Scanner(System.in);

        System.out.print("E-mail do paciente: ");
        String email = sc.nextLine();

        PacienteService servico = new PacienteService();

        return servico.getPacientePorEmail(email);
    }

    private static void leDataHora(AgendaCompromisso compromisso) {
        LocalDate data;
        LocalTime horaInicio;
        LocalTime horaFim;

        Scanner sc = new Scanner(System.in);

        System.out.print("Data do Compromisso (yyyy-MM-dd: ");
        data = LocalDate.parse(sc.nextLine());

        System.out.print("Hora de Início (HH:mm): ");
        horaInicio = LocalTime.parse(sc.nextLine());

        System.out.print("Hora do Fim (HH:mm): ");
        horaFim = LocalTime.parse(sc.nextLine());

        compromisso.setDataHoraInicio(LocalDateTime.of(data, horaInicio));
        compromisso.setDataHoraFim(LocalDateTime.of(data, horaFim));
    }

    private static Dentista pesquisarDentista() {
        Scanner sc = new Scanner(System.in);

        System.out.print("E-mail do dentista: ");
        String email = sc.nextLine();

        UsuarioService servico = new UsuarioService();

        Usuario usuario = servico.getUsuarioPorEmail(email);

        if (usuario == null) {
            System.out.println("Dentista não encontrado!");
            return null;
        } else if (!(usuario instanceof Dentista)) {
            System.out.println("O e-mail informado não é de um dentista!");
            return null;
        }

        return  (Dentista) usuario;
    }

    private static void inserirCompromissoExterno(Dentista dentista) {
        Scanner sc = new Scanner(System.in);

        AgendaCompromissoExterno compromisso = new AgendaCompromissoExterno();

        leDataHora(compromisso);

        System.out.print("Descrição do compromisso: ");
        compromisso.setDescricao(sc.nextLine());

        try {
            dentista.getAgenda().Agendar(compromisso);
            System.out.println("Agendamento de compromisso externo efetuado com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void consultarAgenda(Dentista dentista) {
        System.out.printf("Agenda do(a) dentista %s:\n", dentista.getNome());
        for (AgendaCompromisso compromisso: dentista.getAgenda().getCompromissosAgendados()) {
            System.out.printf("  %s - %s: %s\n", compromisso.getDataHoraInicio(), compromisso.getDataHoraFim(), compromisso.getDescricao());
        }
    }
}
