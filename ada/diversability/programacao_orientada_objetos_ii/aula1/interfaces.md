# Aula 1 - Interfaces

## O que são interfaces?

A interface é um recurso muito utilizado em Java e outras linguagens orientadas a objeto. 

Em uma interface definimos métodos que uma classe que implementar aquela interface deverá cumprir.

Em Java, uma interface não é uma classe, mas um conjunto de requisitos para classes que precisam adequar-se a ela. 

Assim, vamos pensar em interfaces como contratos onde o foco está em "o quê" deve ser feito, mas não "como".

Nota: Em Java podemos definir herança apenas de uma superclasse, enquanto que podemos implementar várias interfaces.

Para entender melhor sobre interfaces e contratos, vamos adicionar à classe Empregado uma funcionalidade de comparação para pode realizar ordenações de forma prática. 

Nosso critério de ordenação serão as matrículas.

## Sintaxe

Vamos analisar a interface java.lang.Comparable pertencente à linguagem Java.

```Java
public interface Comparable {
    int compareTo (Object other);
}
```

Semelhante à declaração de classes e enums, temos uma palavra-chave para declarar uma nova interface: é a interface. 

Em seguida, note que apesar de não haver definido o modificador de visibilidade public, em interfaces, os métodos são públicos. 

Veja que o método não possui corpo. Ou seja, este é um contrato. 

Toda classe que implementar esta interface precisa fornecer uma implementação para todos os métodos definidos.

```Java
public class Empregado implements Comparable {
    private int matricula;
    //...
    @Override
    public int compareTo(Object other) {
        Empregado empregado = (Empregado) other;
        if (this.matricula < empregado.matricula) {
            return -1;
        }
        if (this.matricula > empregado.matricula) {
            return 1;
        }
        return 0;
    }
}
```

Alteramos a classe Empregado adicionando a palavra-chave implements e o nome da interface para definir que Empregado cumpre o contrato definido em Comparable. 

Com isso, estamos preparando para adicionar o critério de ordenação.

A anotação @Override usada em heranças também pode ser usada aqui na implementação de métodos de interfaces. 

Isso facilita a leitura do programador.

Veja que agora foi necessário adicionar o modificador de visibilidade public. 

Em seguida, usamos uma transformação inversa ao que foi discutido no polimorfismo. 

Como a interface Comparable define que o tipo do parâmetro do método compareTo é um Object, então, devemos seguir o contrato. 

No entanto, não podemos comparar "maçãs com laranjas", isto é, só faz sentido comparar objetos do tipo Empregado com outros objetos do tipo Empregado. 

Assim, usamos o recurso de casting do Java.

Voltando à implementação do método compareTo, veja que definimos a comparação entre objetos Empregado através de comparação dos atributos matricula. 

Note que este é um método de objeto, ou seja, estamos comparando este objeto e outro. Por exemplo,

```Java
Empregado joao = new Empregado();
Empregado maria = new Empregado(); 

int result = joao.compareTo(maria);
```

## A interface java.util.Collection

Até agora, trabalhamos com a estrutura de dados array para representar grupos de valores semelhantes em uma mesma variável. 

No entanto, não é prático ficar manipulando arrays diretamente.

Java fornece uma ampla e poderosa estrutura de coleções através da API Java Collection.

Ainda não é o momento de estuda-la em detalhes. 

Mas, de forma resumida, temos a interface java.util.List que representa as estruturas de lista, e a sua classe mais popular é a java.util.ArrayList, 
que implementa o contrato definido em List usando estruturas de arrays.

## O método Collections.sort

Finalmente, vamos criar um programa para testar o comportamento de nossa implementação do compareTo e verificar se a ordenação está conforme o esperado.

```Java
package br.com.letscode.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        Empregado joao = new Empregado("Joao", 100, BigDecimal.valueOf(2000d));
        Empregado maria = new Empregado("Maria", 200, BigDecimal.valueOf(2000d));
        Empregado paulo = new Empregado("Paulo", 150, BigDecimal.valueOf(2000d));

        List<Empregado> empregadoList = new ArrayList<>();
        empregadoList.add(joao);
        empregadoList.add(maria);
        empregadoList.add(paulo);

        System.out.println(">>>> Antes da ordenação.%n%n");
        for (Empregado empregado : empregadoList) {
            System.out.println(empregado);
        }

        Collections.sort(empregadoList);

        System.out.printf(">>>> Depois da ordenação.%n%n");
        for (Empregado empregado : empregadoList) {
            System.out.println(empregado);
        }
    }
}
```

Conforme já vimos no polimorfismo, podemos fazer uma substituição de subclasse por superclasse e, também, de classe por interface. 

Note essa abordagem na declaração da variável empregadoList. 

Em seguida, adicionamos na lista cada um dos três objetos Empregado criados através do método add. 

Por fim, executando o método de classe Collections.sort (onde Collections pertence ao pacote java.util), 
que recebe como parâmetro nossa lista, temos uma chamada implícita ao método compareTo de Comparable que implementamos em Empregado.

A saída no console informa que nossa implementação está correta, pois os objetos de empregadoList aparecem ordenados pela matrícula.

>>>> Antes da ordenação.

```Shell
Empregado{nome='Joao', matricula=100, salario=2000.0}
Empregado{nome='Maria', matricula=200, salario=2000.0}
Empregado{nome='Paulo', matricula=150, salario=2000.0}
```

>>>> Depois da ordenação.

```Shell
Empregado{nome='Joao', matricula=100, salario=2000.0}
Empregado{nome='Paulo', matricula=150, salario=2000.0}
Empregado{nome='Maria', matricula=200, salario=2000.0}
```

## Interface de marcação

Interface de marcação é um recurso utilizado para quando temos interfaces que não possuem métodos ou campos. 

A implementação dessa interface em um classe serve para marcar que uma classe pertence à categoria da interface implementada e indicar à JVM 
que aquela classe terá um comportamento de acordo com o contrato definido.

Veja um exemplo

```
public interface Ave {

}
```

Implementação

```
public class Tucano implements Ave {
    private int id;
    private String nome;
    private String nacionalidade;
}
```

```Java
public class Pardal implements Ave {
    private int id;
    private String nome;
    private String nacionalidade;
}
```

## Materiais complementares

[O que é o marcador de interface em Java](https://www.devmedia.com.br/o-que-e-o-marcador-de-interface-em-java/28580)

## Referências

[API Java Collection](https://docs.oracle.com/javase/tutorial/collections/index.html)
