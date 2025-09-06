import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
    
        Empregado joao = new Empregado("Joao", 100, BigDecimal.valueOf(3000d));
        Empregado maria = new Empregado("Maria", 200, BigDecimal.valueOf(1500d));
        Empregado paulo = new Empregado("Paulo", 150, BigDecimal.valueOf(2000d));

        List<Empregado> empregadoList = new ArrayList<>();
        empregadoList.add(joao);
        empregadoList.add(maria);
        empregadoList.add(paulo);

        System.out.println(">>>> Antes da ordenação");
        for (Empregado empregado : empregadoList) {
            System.out.println(empregado);
        }

        Collections.sort(empregadoList);

        System.out.println("\n>>>> Depois da ordenação");
        for (Empregado empregado : empregadoList) {
            System.out.println(empregado);
        }
    }
}
