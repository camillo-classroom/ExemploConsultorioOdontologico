package State;

import Models.*;

import java.util.ArrayList;

public class Dados {
    public static ArrayList<Usuario> getUsuarios() {
        if (usuarios.isEmpty()) {
            /*
            Administrador adm = new Administrador();
            adm.setNome("Admin");
            adm.setEmail("admin@email.com");
            adm.setSenha("@dmin123");
            usuarios.add(adm);
            */
            padrao();
        }

        return usuarios;
    }

    public static void padrao() {
        Administrador adm = new Administrador();
        adm.setNome("Admin");
        adm.setEmail("a");
        adm.setSenha("a");
        adm.setPrimeiroLogin(false);
        usuarios.add(adm);

        Dentista den = new Dentista();
        den.setNome("Dentista 1");
        den.setEmail("d");
        den.setSenha("d");
        den.setPrimeiroLogin(false);
        usuarios.add(den);

        Secretario sec = new Secretario();
        sec.setNome("Secretario 1");
        sec.setEmail("s");
        sec.setSenha("s");
        sec.setPrimeiroLogin(false);
        usuarios.add(sec);

        Paciente p = new Paciente();
        p.setNome("Paciente 1");
        p.setEmail("p");
        pacientes.add(p);
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
