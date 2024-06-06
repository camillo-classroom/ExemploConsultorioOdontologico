package State;

import Models.Administrador;
import Models.Paciente;
import Models.Usuario;

import java.util.ArrayList;

public class Dados {
    public static ArrayList<Usuario> getUsuarios() {
        if (usuarios.isEmpty()) {
            Administrador adm = new Administrador();
            adm.setNome("Admin");
            adm.setEmail("admin@email.com");
            adm.setSenha("@dmin123");
            usuarios.add(adm);
        }

        return usuarios;
    }

    public static ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        Dados.usuarioLogado = usuarioLogado;
    }

    private static Usuario usuarioLogado = null;

    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
}
