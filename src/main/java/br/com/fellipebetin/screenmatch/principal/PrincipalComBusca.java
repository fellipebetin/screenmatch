package br.com.fellipebetin.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.fellipebetin.screenmatch.excecao.ErrodeConversaoDeAnoException;
import br.com.fellipebetin.screenmatch.modelos.Titulo;
import br.com.fellipebetin.screenmatch.modelos.TituloOmdb;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException, Exception {

		Scanner leitura = new Scanner(System.in);
		String busca = "";
		List<Titulo> titulos = new ArrayList<>();
		
		Gson gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.setPrettyPrinting()
				.create();
		
		while (!busca.equalsIgnoreCase("sair")) {
			
			
			System.out.println("\nDigite um filme para busca: ");
			busca = leitura.nextLine();
			
			if (busca.equalsIgnoreCase("sair")) {
				break;
			}
			
			String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=4a0b25a0";
	
			try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	
				String json = response.body();
				
				if (json.contains("Movie not found!")) {
					throw new Exception("Filme não encontrado.");  
				} else {
					System.out.println(json);
				}
	
				//Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
	
				TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
				System.out.println(meuTituloOmdb);
	
				Titulo meuTitulo = new Titulo(meuTituloOmdb);
				System.out.println("Título já convertido:");
				System.out.println(meuTitulo);
				
				titulos.add(meuTitulo);
				
			} catch (NumberFormatException e) {
				System.out.println("Aconteceu um erro: ");
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Aconteceu um erro de argumento na busca: ");
				System.out.println(e.getMessage());
			} catch (ErrodeConversaoDeAnoException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println(titulos);
		
		FileWriter escrita = new FileWriter("filmes.json");
		escrita.write(gson.toJson(titulos));
		escrita.close();

		System.out.println("O programa finalizou corretamente!");

	}

}
