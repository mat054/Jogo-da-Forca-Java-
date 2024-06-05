package jogo;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static GerenciadorTemas gerenciadorTemas = new GerenciadorTemas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    gerenciarTemas();
                    break;
                case 2:
                    jogar();
                    break;
                case 3:
                    sair = true;
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Gerenciar Temas");
        System.out.println("2. Jogar");
        System.out.println("3. Sair");
    }

    private static void gerenciarTemas() {
        System.out.println("Gerenciamento de Temas:");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar Tema");
        System.out.println("2. Adicionar Palavra a um Tema");
        System.out.println("3. Listar Temas e Palavras");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                adicionarTema();
                break;
            case 2:
                adicionarPalavra();
                break;
            case 3:
                listarTemasEPalavras();
                break;
            default:
                System.out.println("Opção inválida. Escolha uma opção válida.");
        }
    }

    private static void adicionarTema() {
        System.out.println("Digite o nome do novo tema:");
        String nomeTema = scanner.nextLine();
        Tema novoTema = new Tema(nomeTema);
        System.out.println("Digite as palavras relacionadas ao tema (digite 'fim' para parar):");
        String novaPalavra;
        do {
            novaPalavra = scanner.nextLine();
            if (!novaPalavra.equalsIgnoreCase("fim")) {
                novoTema.adicionarPalavra(new Palavra(novaPalavra));
            }
        } while (!novaPalavra.equalsIgnoreCase("fim"));
        gerenciadorTemas.adicionarTema(novoTema);
        System.out.println("Tema adicionado com sucesso!");
    }

    private static void adicionarPalavra() {
        System.out.println("Escolha um tema para adicionar uma palavra:");
        listarTemas();
        int indiceTema = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (indiceTema >= 0 && indiceTema < gerenciadorTemas.getTemas().size()) {
            Tema temaSelecionado = gerenciadorTemas.getTemas().get(indiceTema);
            System.out.println("Digite a palavra a ser adicionada ao tema " + temaSelecionado.getNome() + ":");
            String novaPalavra = scanner.nextLine();
            temaSelecionado.adicionarPalavra(new Palavra(novaPalavra));
            System.out.println("Palavra adicionada com sucesso!");
        } else {
            System.out.println("Índice de tema inválido.");
        }
    }

    private static void listarTemasEPalavras() {
        gerenciadorTemas.listarTemas();
        System.out.println("Escolha um tema para listar as palavras, escreva 0 para o primeiro 1 para o segundo e assim por diante:");
        int indiceTema = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (indiceTema >= 0 && indiceTema < gerenciadorTemas.getTemas().size()) {
            Tema temaSelecionado = gerenciadorTemas.getTemas().get(indiceTema);
            temaSelecionado.listarPalavras();
        } else {
            System.out.println("Índice de tema inválido.");
        }
    }

    private static void listarTemas() {
        System.out.println("Escolha um tema:");
        int indice = 0;
        for (Tema tema : gerenciadorTemas.getTemas()) {
            System.out.println(indice + ". " + tema.getNome());
            indice++;
        }
    }

    private static void jogar() {
        System.out.println("Escolha um tema para jogar:");
        listarTemas();
        int indiceTema = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (indiceTema >= 0 && indiceTema < gerenciadorTemas.getTemas().size()) {
            Tema temaSelecionado = gerenciadorTemas.getTemas().get(indiceTema);
            String palavraSecreta = escolherPalavraSecreta(temaSelecionado);
            iniciarJogo(palavraSecreta);
        } else {
            System.out.println("Índice de tema inválido.");
        }
    }

    private static String escolherPalavraSecreta(Tema tema) {
        ArrayList<Palavra> palavras = tema.getPalavras();
        int indicePalavra = (int) (Math.random() * palavras.size());
        return palavras.get(indicePalavra).getConteudo();
    }

    private static void iniciarJogo(String palavraSecreta) {
        System.out.println("Uma palavra foi selecionada para você!");
        System.out.println("A palavra tem " + palavraSecreta.length() + " caracteres.");

        int erros = 0;
        String palavraAdivinhada = "";
        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraAdivinhada += "_";
        }

        while (erros < 5) {
            System.out.println("Palavra atual: " + palavraAdivinhada);
            System.out.println("Digite uma letra:");
            String letra = scanner.nextLine().toLowerCase();

            if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
                System.out.println("Por favor, digite uma única letra válida.");
                continue;
            }

            if (palavraSecreta.contains(letra)) {
                for (int i = 0; i < palavraSecreta.length(); i++) {
                    if (palavraSecreta.charAt(i) == letra.charAt(0)) {
                        palavraAdivinhada = palavraAdivinhada.substring(0, i) + letra + palavraAdivinhada.substring(i + 1);
                    }
                }
                if (!palavraAdivinhada.contains("_")) {
                    System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                    break;
                }
            } else {
                erros++;
                System.out.println("Letra não encontrada na palavra. Você tem " + (5 - erros) + " tentativas restantes.");
            }
        }

        if (erros >= 5) {
            System.out.println("Você perdeu! Deseja jogar novamente?");
        }
    }

}
