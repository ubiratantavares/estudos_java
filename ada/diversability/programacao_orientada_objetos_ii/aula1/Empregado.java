import java.math.BigDecimal;

public class Empregado implements Comparable<Empregado> {

	private String nome;
    private int matricula;
	private BigDecimal salario;

	public Empregado(String nome, int matricula, BigDecimal salario) {
		this.nome = nome;
		this.matricula = matricula; 
		this.salario = salario;
	}

    @Override
    public int compareTo(Empregado empregado) {
        if (this.matricula < empregado.matricula) {
            return -1;
        }
        if (this.matricula > empregado.matricula) {
            return 1;
        }
        return 0;
    }

    public String toString() {
    	return this.matricula + ", " + this.nome + ", " + this.salario;
    }
}
