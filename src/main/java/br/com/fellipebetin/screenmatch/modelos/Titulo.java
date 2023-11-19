package br.com.fellipebetin.screenmatch.modelos;

import br.com.fellipebetin.screenmatch.excecao.ErrodeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo>{
    private String nome;
	private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;
    
    

    public Titulo(String nome, int anoDeLancamento) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
	}

	public Titulo(TituloOmdb meuTituloOmdb) {
		this.nome = meuTituloOmdb.title();
		
		//if (meuTituloOmdb.year().length() > 4) {
		//	throw new ErrodeConversaoDeAnoException("Não foi possível converter o ano pois tem mais de quatro catacteres.");
		//}
		
		this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year().substring(0,4));
		if (meuTituloOmdb.runtime().equals(null)) {
			this.duracaoEmMinutos = 0;
		} else if (meuTituloOmdb.runtime().equals("N/A")) {
			this.duracaoEmMinutos = 0;	
		} else {
			this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,3).trim());
		}
	}

	public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano){
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Duração em minutos: " + duracaoEmMinutos);
        System.out.println("Incluído no plano: " + incluidoNoPlano);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes ++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

	@Override
	public int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}

	@Override
	public String toString() {
		return "(Nome = " + nome + ", Lançamento = " + anoDeLancamento + ", Duração = " + duracaoEmMinutos + ") ";
	}
	
	
}
