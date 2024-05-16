package Models;

public abstract class Usuario {
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void trocarSenha(String senhaAnterior, String novaSenha, String novaSenhaConferencia) throws Exception {
        if (novaSenha == null || novaSenha.isEmpty()) {
            throw new Exception("A nova senha é inválida!");
        }

        if (!novaSenha.equals(novaSenhaConferencia)) {
            throw new Exception("A nova senha difere da confirmação da senha!");
        }

        if ((senha == null && senhaAnterior == null) || (senha != null && senha.equals(senhaAnterior))) {
            senha = novaSenha;
        } else {
            throw new Exception("A senha anterior é inválida!");
        }
    }
}
