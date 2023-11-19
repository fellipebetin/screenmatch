package br.com.fellipebetin.screenmatch.principal;

import java.util.ArrayList;

import br.com.fellipebetin.screenmatch.calculos.CalculadoraDeTempo;
import br.com.fellipebetin.screenmatch.calculos.FiltroRecomendacao;
import br.com.fellipebetin.screenmatch.modelos.Episodio;
import br.com.fellipebetin.screenmatch.modelos.Filme;
import br.com.fellipebetin.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Velozes e Furiosos",2001);
        meuFilme.setDuracaoEmMinutos(106);
        System.out.println("Duração do Filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost",2004);
        lost.exibeFichaTecnica();
        lost.setTemporadas(6);
        lost.setEpisodiosPorTemporada(24);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração da Série: " + lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);

        Filme outroFilme = new Filme("Mais Velozes e Mais Furiosos",2003);
        outroFilme.setDuracaoEmMinutos(108);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        filtro.filtra(outroFilme);
        
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
        
        //Utilização do var - a partir da versão 10 do Java
        //var faz uma inferência do tipo declarado, ou seja ela sabe que é tipo Filme
        var filmeFellipe = new Filme("Gran Turismo",2023);
        filmeFellipe.setDuracaoEmMinutos(200);
        filmeFellipe.avalia(9);
        
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeFellipe);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(meuFilme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes); // imprime as referencias dos objetos
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).toString());
        
        filmeFellipe.toString();
        
    }
}
