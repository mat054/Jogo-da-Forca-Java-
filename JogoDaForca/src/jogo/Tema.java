package jogo;

import java.util.ArrayList;

public class Tema {
    private String nome;
    private ArrayList<Palavra> palavras;

    public Tema(String nome) {
        this.nome = nome;
        this.palavras = new ArrayList<>();
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Palavra> getPalavras() {
        return palavras;
    }

    public void setPalavras(ArrayList<Palavra> palavras) {
        this.palavras = palavras;
    }

    public void adicionarPalavra(Palavra palavra) {
        if (palavras.size() < 50 && !palavras.contains(palavra)) {
            palavras.add(palavra);
        } else {
            System.out.println("O tema já possui o limite máximo de palavras (50) ou a palavra já existe no tema.");
        }
    }

    public void listarPalavras() {
        System.out.println("Palavras do tema " + nome + ":");
        for (Palavra palavra : palavras) {
            System.out.println(palavra.getConteudo());
        }
    }
}
