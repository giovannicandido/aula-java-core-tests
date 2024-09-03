package br.com.targettrust;

import br.com.targettrust.model.ClassificacaoIMC;
import br.com.targettrust.model.RangeClassificacao;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        var range1 = new RangeClassificacao(10, 20, ClassificacaoIMC.SEM_CLASSIFICACAO);
//        List<RangeClassificacao> ranges = List.of(range1, new RangeClassificacao(40, 50, ClassificacaoIMC.SEM_CLASSIFICACAO));
//        var equals = range1.equals(15d);
//        var contains = ranges.contains(15d);
//        List.of(new RangeClassificacao(10, 20, ClassificacaoIMC.SEM_CLASSIFICACAO), new RangeClassificacao(15, 18, ClassificacaoIMC.SEM_CLASSIFICACAO)).contains(15d);
//        var contains2 = ranges.stream().anyMatch(range -> range.equals(15d));
//
//        var range = ranges.stream().filter(rangef -> rangef.equals(15d)).findFirst();
//        var equalsObject = Objects.equals(15d, range1);
//        var equalObjectInvertido = Objects.equals(range1, 15d);

//        System.out.println(contains);

        testString();


    }

    public static void exemplo() {

        var a = new RangeClassificacao(10, 20, ClassificacaoIMC.SEM_CLASSIFICACAO); // Vai ser marcado como não usado vai sair da memoria depois que a função exemplo finalizar
        var b = new RangeClassificacao(10 , 20, ClassificacaoIMC.SEM_CLASSIFICACAO);


        // a == b; false
        a = b;
        // a = b; // true
        // JVM Garbage collector // Bem avançado

    }
    // Aula 07
    public static void testString() {
        var a = "primeira";
        var b = "primeira";
        var c = new RangeClassificacao(10, 20, ClassificacaoIMC.SEM_CLASSIFICACAO); // Vai ser marcado como não usado vai sair da memoria depois que a função exemplo finalizar
        var d = new RangeClassificacao(10 , 20, ClassificacaoIMC.SEM_CLASSIFICACAO);
        var teste = a == b;
        var teste2 = c == d;

        var e = new String("primeira");
        var f = new String("primeira");

        var teste3 = e == f;
        System.out.println(teste3);
        Charset charset = Charset.forName("ISO-8859-1"); // Latin, Portugues
        Charset charset2 = Charset.forName("UTF-8"); // Universal, representa qualquer linguagem
        Charset charset3 = Charset.forName("ASCII"); // Não tem acentuação, somente ingles.
        String nome = "João";
        var stringNova = "Boas vindas " + nome + ". Tenha um bom dia";

        StringBuffer sb = new StringBuffer();
        sb.append("Boas vindas ");
        sb.append(nome);
        sb.append(". Tenha um bom dia");
        String resultado = sb.toString(); // Converte para uma String quando necessário

        // Ler dados na memoria ou no banco, e vai converter para JSON
        // Quero implementar o conversor.
        // internamente é um opção usar o StringBuffer ou o StringBuilder
        // Template em HMTL no meio do template tem tags. StringBuffer ou StringBuilder pode ajudar.
        // Nota: Não é muito eficiente nesse caso (JSON, XML e HTML)
        // Java 17 possui multiline

        // SQL é uma maravilha
        var boasVindas = """
            Boas vindas, %s Tenha um bom dia.
            Hora: 14:34
        """.formatted(nome);
        // Java 21 preview, tem que habilitar o recurso para usar
/*
        var bemVindo2 = STR."""
                Boas vindas, \{ nome \} Tenha um bom dia.
                Hora: 14:34
                """;
*/

    }

    public static void material08() {
        int valor = 10; // Aloca na maquina o valor 10, bem nativo.
        Integer valor2 = 10; // Aloca na memoria ram o objeto intero com valor 10
        Integer valor3 = Integer.valueOf(10); // Integer da metodos para trabalhar

        Integer valor4 =  valor;

        // Generics só trabalha com Classe. Não com primitivo.
        // Não compila
//         List<int> listaInteiros = List.of(1, 2, 3, 4);
         List<Integer> listaInteiros = List.of(1, 2, 3, 4);
         // Isso eu so vi no java.
        // Outras linguages que vieram depois tudo é objeto.
        // Enuns

        // Basico do enum
        Cor blue = Cor.BLUE;
        Cor green = Cor.valueOf("GREEN");
        // vai lancar excecao
        Cor green1 = Cor.valueOf("green");

        CountryCode us = CountryCode.US;

        us.getCountryCharset();
        us.getMoneyCode();
        Locale.IsoCountryCode isoCountryCode = Locale.IsoCountryCode.valueOf("US");
    }
}