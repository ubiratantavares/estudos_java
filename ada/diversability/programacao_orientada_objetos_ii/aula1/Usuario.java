import java.io.Serializable;

class Usuario implements Serializable {

    private static final long serialVersionUID = 1L; // versão da classe para serialização

    private String nome;

    private int idade;

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}
