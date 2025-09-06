// Classe de teste
public class Main {
    public static void main(String[] args) {

        Arquivo arquivo = new Arquivo("usuarios.dat");

        // Gravar usuários
        arquivo.gravarUsuario(new Usuario("Ana", 25));
        arquivo.gravarUsuario(new Usuario("João", 30));
        arquivo.gravarUsuario(new Usuario("Maria", 20));

        // Ler usuários
        System.out.println("Usuários gravados no arquivo:");
        for (Usuario u : arquivo.lerUsuarios()) {
            System.out.println(u);
        }
    }
}
