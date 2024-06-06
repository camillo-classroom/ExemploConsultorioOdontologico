package Views;

import Models.*;
import Services.PacienteService;

import java.util.Scanner;

public class PacienteView {
    public static void apresentarMenu() {
        System.out.println("Menu de pacientes (escolha uma opção):");
        System.out.println(" 1 - Listar");
        System.out.println(" 2 - Inserir");
        System.out.println(" 3 - Alterar");
        System.out.println(" 4 - Excluir");
        System.out.print("Opção: ");

        boolean continuar;

        do {
            continuar = false;

            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    listar();
                    break;
                case 2:
                    inserir();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    excluir();
                    break;
                default:
                    continuar = true;
            }
        } while (continuar);
    }

    private static void listar() {
        PacienteService servico = new PacienteService();

        System.out.println("\nLista de Pacientes do Sistema:");

        for (Paciente usr: servico.getPacientes()) {
            System.out.printf("%s - %s - %s\n", usr.getNome(), usr.getEmail(), usr.getTelefone());
        }

        System.out.println("-----------------------------\n");
    }

    private static void inserir() {
        System.out.println("\nInserindo Paciente:");
        Paciente paciente = new Paciente();
        lerPaciente(paciente);
        PacienteService servico = new PacienteService();
        servico.inserir(paciente);
    }

    private static void lerPaciente(Paciente paciente) {
        Scanner sc = new Scanner(System.in);

        System.out.print("  Nome: ");
        paciente.setNome(sc.nextLine());
        System.out.print("  E-mail: ");
        paciente.setEmail(sc.nextLine());
        System.out.print("  Telefone: ");
        paciente.setTelefone(sc.nextLine());
    }

    private static void alterar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("E-mail do(a) paciente a ser alterado(a): ");
        String email = sc.nextLine();
        PacienteService servico = new PacienteService();

        Paciente paciente = servico.getPacientePorEmail(email);

        if (paciente == null) {
            System.out.println("Usuário não encontrado");
            return;
        }

        System.out.print("  Nome: ");
        paciente.setNome(sc.nextLine());
        System.out.print("  Telefone: ");
        paciente.setTelefone(sc.nextLine());

        try {
            servico.alterar(paciente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void excluir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("E-mail do(a) paciente a ser excluído(a): ");
        String email = sc.nextLine();
        PacienteService servico = new PacienteService();

        Paciente paciente = servico.getPacientePorEmail(email);

        if (paciente == null) {
            System.out.println("Paciente não encontrado");
            return;
        }

        try {
            servico.excluir(paciente.getEmail());
            System.out.println("Paciente excluído(a) com sucesso!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
