package br.com.fellipebetin.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.com.fellipebetin.screenmatch.modelos.Filme;
import br.com.fellipebetin.screenmatch.modelos.Serie;
import br.com.fellipebetin.screenmatch.modelos.Titulo;

public class PrincipalComListas {
	public static void main(String[] args) {
		Filme meuFilme = new Filme("Velozes e Furiosos",2001);
		meuFilme.avalia(9);
		Filme outroFilme = new Filme("Mais Velozes e Mais Furiosos",2003);
		outroFilme.avalia(6);
		var filmeFellipe = new Filme("Gran Turismo",2023);
		filmeFellipe.avalia(10);
		Serie lost = new Serie("Lost",2004);
		
		
		ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeFellipe);
        lista.add(outroFilme);
        lista.add(meuFilme);
        lista.add(lost);
        
        for (Titulo item : lista) {
			System.out.println(item.getNome());
			if (item instanceof Filme filme && filme.getClassificacao() > 2) {
				System.out.println("Classificação: " + filme.getClassificacao());
			}
		}
        //Outros exemplos
        //lista.forEach(item -> System.out.println(item.getNome()));
        //lista.forEach(System.out::println);
        
        List<String> listaArtista = new LinkedList<>();
        listaArtista.add("Keanu Reeves");
        listaArtista.add("Adam Sandler");
        listaArtista.add("Will Smith");
        listaArtista.add("Paul Walker");
        
        System.out.println(listaArtista);
        Collections.sort(listaArtista);
        System.out.println(listaArtista);
        
        System.out.println("Lista de títulos ordenados:");
        Collections.sort(lista);
        System.out.println(lista);
        
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
        
	}
}
