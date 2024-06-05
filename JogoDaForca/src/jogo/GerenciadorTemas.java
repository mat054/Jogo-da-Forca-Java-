package jogo;

import java.util.ArrayList;

public class GerenciadorTemas {
    private ArrayList<Tema> temas;

    public GerenciadorTemas() {
        this.temas = new ArrayList<>();
        
        Tema tema1 = new Tema("Animais");
        tema1.adicionarPalavra(new Palavra("cachorro"));
        tema1.adicionarPalavra(new Palavra("gato"));
        tema1.adicionarPalavra(new Palavra("elefante"));
        tema1.adicionarPalavra(new Palavra("leão"));
        tema1.adicionarPalavra(new Palavra("tigre"));
        adicionarTema(tema1);

        Tema tema2 = new Tema("Frutas");
        tema2.adicionarPalavra(new Palavra("banana"));
        tema2.adicionarPalavra(new Palavra("maçã"));
        tema2.adicionarPalavra(new Palavra("laranja"));
        tema2.adicionarPalavra(new Palavra("uva"));
        tema2.adicionarPalavra(new Palavra("abacaxi"));
        adicionarTema(tema2);
    }
        

    public ArrayList<Tema> getTemas() {
		return temas;
	}


	public void setTemas(ArrayList<Tema> temas) {
		this.temas = temas;
	}


	public void adicionarTema(Tema tema) {
        if (!temas.contains(tema)) {
            temas.add(tema);
        } else {
            System.out.println("O tema já existe na lista.");
        }
    }

    public void listarTemas() {
        System.out.println("Lista de temas:");
        for (Tema tema : temas) {
            System.out.println(tema.getNome());
        }
    }
    
    

    // Outros métodos para manipulação dos temas...
}

