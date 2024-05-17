package Views;

import Models.Usuario;
import Services.UsuarioService;
import Views.UsuarioView;

import java.util.Scanner;

public class SistemaView {
    public static void iniciar() {
        UsuarioService servico = new UsuarioService();
        Usuario usuarioLogado;

        boolean continuar;

        do {
            usuarioLogado = servico.getUsuarioLogado();

            if (usuarioLogado == null) {
                UsuarioView.login();
            }

            usuarioLogado = servico.getUsuarioLogado();

            if (usuarioLogado != null) {
                continuar = apresentarMenu(usuarioLogado);
            } else {
                continuar = true;
            }
        } while (continuar);
    }

    private static boolean apresentarMenu(Usuario usuarioLogado) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Olá %s!\n", usuarioLogado.getNome());
        System.out.println("Menu (escolha a opção desejada):");
        System.out.println(" 0 - Sair");
        System.out.println(" 1 - Logout");
        System.out.print(" Opção: ");
        int opcao = sc.nextInt();

        while (true) {
            switch (opcao) {
                case 0:
                    return false;
                case 1:
                    UsuarioService servico = new UsuarioService();
                    servico.logout();
                    return true;
                default:
                    System.out.println(" Opção inválida!");
            }
        }
    }
}
