import java.util.Scanner;

public class AccessControl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados do usuário
        boolean hasPermission = scanner.nextBoolean(); // Lê um valor booleano (true ou false)
        int age = scanner.nextInt(); // Lê a idade como inteiro

        if (hasPermission) {
          if (age >= 18) {
            System.out.println("Acesso permitido");
          } else {
            System.out.println("Idade insuficiente");
          } 
        } else {
            System.out.println("Acesso negado");
        } 
        scanner.close();
    }
}

