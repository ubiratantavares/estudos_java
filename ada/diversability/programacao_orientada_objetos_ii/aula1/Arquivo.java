import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Classe Arquivo
class Arquivo {

    private static final long serialVersionUID = 1L;

    private String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    // Grava um usuário no arquivo
    public void gravarUsuario(Usuario usuario) {
        List<Usuario> usuarios = lerUsuarios(); // lê os existentes
        usuarios.add(usuario); // adiciona novo

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(usuarios);
            System.out.println("Usuário gravado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lê todos os usuários do arquivo
    public List<Usuario> lerUsuarios() {
        File file = new File(nomeArquivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
