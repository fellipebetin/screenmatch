package br.com.fellipebetin.screenmatch.modelos;

import br.com.fellipebetin.screenmatch.calculos.CalculadoraDeTempo;
import br.com.fellipebetin.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("Velozes e Furiosos");
        meuFilme.setAnoDeLancamento(2001);
        meuFilme.setDuracaoEmMinutos(106);
        System.out.println("Duração do Filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2004);
        lost.exibeFichaTecnica();
        lost.setTemporadas(6);
        lost.setEpisodiosPorTemporada(24);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração da Série: " + lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);

        Filme outroFilme = new Filme();
        outroFilme.setNome("Mais Velozes e Mais Furiosos");
        outroFilme.setAnoDeLancamento(2003);
        outroFilme.setDuracaoEmMinutos(108);
        calculadora.inclui(outroFilme);

        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());
    }
}
