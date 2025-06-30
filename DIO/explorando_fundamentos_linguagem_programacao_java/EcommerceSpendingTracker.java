import java.util.Scanner;
import java.util.Locale;

public class EcommerceSpendingTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int purchaseCount = scanner.nextInt();

        if (purchaseCount == 0) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            double total = 0.0;
            for (int i = 0; i < purchaseCount; i++) {
                double purchaseValue = scanner.nextDouble();
                total += purchaseValue;
            }
            double media = total / purchaseCount;

            System.out.printf("%.2f%n", total);
            System.out.printf("%.2f%n", media); // TODO: Imprima a média
        }
        scanner.close();
    }
}
