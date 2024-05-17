package Services;

import Models.Usuario;
import State.Dados;

public class UsuarioService {
    public void login(String email, String senha) throws Exception {
        for (Usuario usr: Dados.getUsuarios()) {
            if (usr.getEmail().equals(email)) {
                if (usr.getSenha().equals(senha)) {
                    Dados.setUsuarioLogado(usr);
                    return;
                } else {
                    throw new Exception("E-mail e/ou senha inválido(s)!");
                }
            }
        }

        throw new Exception("E-mail e/ou senha inválido(s)!");
    }

    public void logout() {
        Dados.setUsuarioLogado(null);
    }

    public Usuario getUsuarioLogado() {
        return Dados.getUsuarioLogado();
    }
}
