package br.com.fellipebetin.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4) {
            System.out.println(classificavel.getNomeClassificavel() + " -> Está entre os preferidos do momento");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println(classificavel.getNomeClassificavel() + " -> Muito bem avaliado no momento!");
        } else {
            System.out.println(classificavel.getNomeClassificavel() + " -> Coloque na sua lista para assistir depois");
        }
    }
}
