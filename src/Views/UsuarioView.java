package Views;
import Models.Usuario;
import Services.UsuarioService;
import java.util.Scanner;

public class UsuarioView {
    public static void login() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Login:");
            System.out.print("   E-mail: ");
            String email = sc.nextLine();
            System.out.print("   Senha: ");
            String senha = sc.nextLine();

            UsuarioService servico = new UsuarioService();

            try {
                servico.login(email, senha);
                if (servico.getUsuarioLogado().isPrimeiroLogin()) {
                    trocarSenha(servico.getUsuarioLogado());
                    logout();
                }
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void logout() {
        UsuarioService servico = new UsuarioService();
        servico.logout();
        System.out.println("Usuário desconectado com sucesso!");
    }

    public static void trocarSenha(Usuario usuario) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("É necessário trocar a senha do usuário %s:\n", usuario.getNome());

            System.out.print("Senha atual: ");
            String senhaAtual = sc.nextLine();

            System.out.print("Nova senha: ");
            String novaSenha = sc.nextLine();

            System.out.print("Nova senha - Confirmação: ");
            String novaSenhaConfirmacao = sc.nextLine();

            try {
                usuario.trocarSenha(senhaAtual, novaSenha, novaSenhaConfirmacao);
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
