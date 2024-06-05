# Jogo da Forca

Este é um projeto em Java que implementa o clássico jogo da forca. O programa permite ao usuário gerenciar temas e palavras associadas a esses temas, além de jogar o jogo escolhendo letras para adivinhar a palavra secreta.

## Funcionalidades

### Menu Inicial
O programa exibe um menu inicial com as seguintes opções:
1. **Gerenciar Conteúdo**
2. **Jogar**
3. **Sair**

### 1. Gerenciar Conteúdo
Nesta opção, o usuário pode gerenciar temas e palavras associadas. As funcionalidades incluem:

#### Cadastro de Temas
- O usuário pode cadastrar até 50 temas diferentes.
- Cada tema possui um nome único.
- Não podem existir temas com o mesmo nome.

#### Listagem de Temas e Palavras
- O usuário pode listar todos os temas cadastrados no sistema.
- Para cada tema listado, também são exibidas as palavras associadas a ele.

#### Cadastro de Palavras
- O usuário pode cadastrar até 50 palavras para cada um dos temas cadastrados.
- Para cadastrar uma palavra, o usuário deve primeiro escolher um dos temas existentes.
- Não podem existir palavras iguais dentro de um mesmo tema.

### 2. Jogar
Nesta opção, o usuário pode jogar o jogo da forca. As funcionalidades incluem:

#### Seleção de Tema
- Antes de iniciar um jogo, o usuário deve selecionar um tema.
- O programa exibe todos os temas disponíveis para o usuário escolher.

#### Jogar
- Após a seleção do tema, o programa escolhe uma palavra aleatoriamente dentro do tema selecionado.
- O programa informa ao usuário a quantidade de caracteres da palavra secreta.
- O usuário deve tentar adivinhar a palavra, escolhendo uma letra por vez.
- Em cada rodada, o usuário deve escolher uma letra:
  - Caso a letra já tenha sido tentada, o programa mostra a mensagem: "Tente outra letra!"
  - Para cada letra tentada pelo usuário e não presente na palavra, é contabilizado um erro.
  - O usuário pode ter no máximo cinco erros. Após a quinta tentativa errada, o programa mostra a mensagem: "Você perdeu! Deseja jogar novamente?".
  - Caso o usuário acerte a palavra, o programa mostra a mensagem: "Parabéns! Você acertou a palavra! Deseja jogar novamente?".

### 3. Sair
- O programa exibe o menu inicial até que a opção "Sair" seja escolhida.
- Caso a opção "Sair" seja escolhida, o programa se encerra.

## Requisitos Obrigatórios
- O programa é escrito utilizando o paradigma orientado a objetos em Java.
- A solução modela pelo menos uma agregação.
- A solução pré-carrega o software com pelo menos dois temas e cinco palavras para cada tema.
- A solução não possui erros de compilação nem erros em tempo de execução.

## Como Jogar
1. Clone o repositório para sua máquina local:
    ```sh
    git clone https://github.com/seu_usuario/jogo-da-forca.git
    ```

2. Compile o programa Java:
    ```sh
    javac -d bin src/jogo/*.java
    ```

3. Execute o programa:
    ```sh
    java -cp bin jogo.JogoDaForca
    ```

4. O menu inicial será exibido com as opções:
    ```
    1. Gerenciar Conteúdo
    2. Jogar
    3. Sair
    ```
    - Para gerenciar conteúdo, escolha a opção 1 e siga as instruções para cadastrar temas e palavras.
    - Para jogar, escolha a opção 2, selecione um tema e comece a adivinhar as letras da palavra secreta.
    - Para sair, escolha a opção 3.

5. Siga as instruções exibidas no terminal para interagir com o jogo.

## Regras do Jogo da Forca
- O jogo começa com a seleção de um tema pelo usuário.
- O programa escolhe aleatoriamente uma palavra dentro do tema selecionado.
- O usuário é informado sobre a quantidade de caracteres da palavra secreta.
- O usuário tenta adivinhar a palavra, escolhendo uma letra por vez.
- Caso a letra escolhida já tenha sido tentada, o programa exibe a mensagem: "Tente outra letra!".
- Para cada letra errada, é contabilizado um erro. O usuário pode ter no máximo cinco erros.
- Se o usuário atingir cinco erros, o jogo exibe a mensagem: "Você perdeu! Deseja jogar novamente?".
- Se o usuário acertar a palavra, o jogo exibe a mensagem: "Parabéns! Você acertou a palavra! Deseja jogar novamente?".

## Estrutura do Código
- `Palavra.java`: Classe que representa uma palavra no jogo.
- `Tema.java`: Classe que representa um tema no jogo, contendo uma lista de palavras.
- `GerenciadorTemas.java`: Classe que gerencia os temas e suas respectivas palavras.
- `JogoDaForca.java`: Classe principal que contém o método `main` e gerencia a interação com o usuário.

## Exemplo de Uso
1. Ao iniciar o programa, o menu inicial é exibido.
2. Escolha a opção "1. Gerenciar Conteúdo" para cadastrar novos temas e palavras.
3. Escolha a opção "2. Jogar" para iniciar uma partida. Selecione um tema e comece a adivinhar as letras da palavra secreta.
4. Escolha a opção "3. Sair" para encerrar o programa.

---

