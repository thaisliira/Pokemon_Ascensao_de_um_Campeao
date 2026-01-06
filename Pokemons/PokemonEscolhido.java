package Pokemon_Ascensao.Pokemons;

import Pokemon_Ascensao.*;
import Pokemon_Ascensao.Enum.Status;
import Pokemon_Ascensao.Enum.TipoItem;
import Pokemon_Ascensao.Enum.TipoPokemon;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PokemonEscolhido extends Pokemon {

    private FormaEvolutiva formaAtual;
    private int moedas;
    private final ArrayList<Item> Inventario;

    public PokemonEscolhido(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, Status status, FormaEvolutiva formaAtual, int moedas) {
        super(tipo,nome,level,experiencia,hpAtual,hpMax,formaAtual.getAtaqueBase(),formaAtual.getAtaqueEspecial(),formaAtual.getDefesaBase(),formaAtual.getDefesaEspecial(), status);

        this.formaAtual = formaAtual;
        this.moedas = moedas;
        this.Inventario = new ArrayList<>();
    }

    public int getMoedas() {
        return moedas;
    }

    /**
     * Função que exibe o status do meu pokemon: vida, ataque, defesa...
     */
    public void exibirDetalhesPoke() {
        System.out.println("\n" + ConsoleColors.PURPLE_BACKGROUND  +" -------- " + this.nome.toUpperCase() + " (Lvl " + this.level + ") --------" + ConsoleColors.RESET);
        System.out.println("Experiência(XP): " + this.experiencia);
        System.out.println("❤️ Vida(HP): " + this.hpAtual + "/" + this.hpMax);
        System.out.println("\uD83D\uDC4A\uD83C\uDFFC Atk: " + this.ataque + " | \uD83D\uDEE1️ Def: " + this.defesa);
        System.out.println("\uD83D\uDC4A\uD83C\uDFFC Atk Sp: " + this.ataqueEspecial + " | \uD83D\uDEE1️ Def Sp: " + this.defesaEspecial);
        System.out.println("\uD83D\uDCDB Status: " + this.status);
    }

    /**
     * Função com menu de opção de ataque
     * @param inimigo inimigo que o pokémon está a batalhar
     * @return retorna se o inimigo foi derrotado ou não
     * @throws FileNotFoundException se o arquivo não existir
     * @throws InterruptedException se a execução do programa for interrompida enquanto espera
     */
    @Override
    public boolean atacar(Pokemon inimigo) throws FileNotFoundException, InterruptedException {
        Scanner jogador = new Scanner(System.in);
        boolean roundEncerrado = false;
        boolean inimigoDerrotado = false;

        while (!roundEncerrado) {
            System.out.println(ConsoleColors.CYAN_BOLD + "\n-------- ROUND (" + this.nome + ") --------" + ConsoleColors.RESET);
            System.out.println("1. Ataque Básico \uD83D\uDC4A\uD83C\uDFFC");
            System.out.println("2. Ataque Especial ✨");
            System.out.println("3. Inventário \uD83C\uDF92");
            System.out.println("4. Exibir Status do meu Pokemon");
            System.out.print("Escolha: ");

            int escolha;

            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
                jogador.nextLine();
            } else {
                System.out.println("⚠️ Entrada inválida. Digite um número.");
                jogador.nextLine();
                continue;
            }

            int dano;

            switch (escolha) {
                case 1:
                    dano = this.ataque - inimigo.getDefesa();
                    // condição se a defesa for maior que o ataque
                    if (dano <= 0) dano = 2;

                    System.out.println("\n👊 " + this.nome + " usou um Ataque Básico!");
                    System.out.println("💥 Causou " + dano + " de dano!");
                    inimigo.receberDano(dano);
                    roundEncerrado = true;
                    break;
                case 2:
                    dano = this.ataqueEspecial - inimigo.getDefesaEspecial();
                    if (dano <= 0) dano = 2;
                    System.out.println("\n✨ " + this.nome + " usou um Ataque Especial!");
                    System.out.println("💥 Causou " + dano + " de dano!");
                    inimigo.receberDano(dano);
                    roundEncerrado = true;
                    break;
                case 3:
                    listarItens();
                    break;
                case 4:
                    exibirDetalhesPoke();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        // retorno para saber se o inimigo foi derrotado
        if (inimigo.getHpAtual() <= 0) {
            inimigoDerrotado = true;
        }
        return inimigoDerrotado;
    }

    /**
     * Função que herda do elemento pai, mas imprime uma mensagem específica
     * @param dano subtrai do valor do HP
     */
    @Override
    public void receberDano(int dano) throws InterruptedException {
        // chama a função receber dano da classe super e aplica
        super.receberDano(dano);
        if (this.hpAtual <= 0) {
            Audio.playMusic("AudioFiles/gameover.wav");
            System.out.println("☠️☠️☠️ Game over ☠️☠️☠️");
            System.out.println("Seu Pokémon não resistiu e morreu...⚰️");
            Thread.sleep(3400);
            System.exit(0);
        } else if (this.hpAtual != 100){
            System.out.println("Você sobreviveu a esse round mas não baixe a guarda!");
            this.status = Status.MACHUCADO;
        }
    }

    /**
     * Função que adiciona ganho de experiência ao Pokemon após cada batalha
     * @param ganhoDeXP após batalha
     * @throws FileNotFoundException se o arquivo não existir
     */
    public void ganharXP(int ganhoDeXP) throws FileNotFoundException {
        this.experiencia += ganhoDeXP;
        System.out.println("\n \uD83E\uDD29 " + this.nome + " ganhou " + ganhoDeXP + " de experiência!");

        while (this.experiencia >= 50) {
            this.experiencia -= 50;
            subirDeNivel();
        }
    }

    /**
     * Função que permite o pokemon subir de nível conforme o XP e dependendo do nivel pode ou não evoluir
     * @throws FileNotFoundException se o arquivo não existir
     */
    public void subirDeNivel() throws FileNotFoundException {
        this.level++;
        System.out.println("🎉 LEVEL UP! " + this.nome + " subiu para o " + ConsoleColors.BLUE_BOLD + "nível " +  this.level + ConsoleColors.RESET + "!");

        if (formaAtual.getProximaForma() != null && this.level >= formaAtual.getProximaForma().getLevelNecessario()) {
            evoluir();
        }
        if (this.level == 8) {
            System.out.println("\nSeu Pokemon está quase pronto para participar do Torneio!");
        }
    }

    /**
     * Função que permiete evolução do pokemon e imprime a arte correspondente
     * @throws FileNotFoundException se o arquivo não existir
     */
    public void evoluir() throws FileNotFoundException {
        FormaEvolutiva novaForma = formaAtual.getProximaForma();

        System.out.println("\n------------------------------------------------");
        System.out.println("✨ O quê? O que está acontecendo? " + this.nome + " está evoluindo!");
        System.out.println("...... \uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F\uD83C\uDF1F ......");
        System.out.println("......... \uD83C\uDF2B️\uD83C\uDF2B️\uD83C\uDF2B️ .........");

        this.formaAtual = novaForma;
        this.setNome(novaForma.getNome());
        this.setAtaque(novaForma.getAtaqueBase());
        this.setAtaqueEspecial(novaForma.getAtaqueEspecial());
        this.setDefesa(novaForma.getDefesaBase());
        this.setDefesaEspecial(novaForma.getDefesaEspecial());

        System.out.println("\n🌟 PARABÉNS! Seu Pokémon evoluiu para " + ConsoleColors.PURPLE_BRIGHT +  this.nome + ConsoleColors.RESET + "!");
        System.out.println("Seus atributos aumentaram drasticamente!");
        System.out.println("------------------------------------------------\n");
        Audio.playMusic("AudioFiles/" + this.nome.toLowerCase() + ".wav");
        imprimirArtePokemon();
    }

    /**
     * Imprime arquivo .txt do pokemon
     * @throws FileNotFoundException se o arquivo não existir
     */
    public void imprimirArtePokemon() throws FileNotFoundException {
        String nomeArquivo = "Artes/" + this.nome.toLowerCase() + ".txt";
        File arquivo = new File(nomeArquivo);

        // condição para verificar se existe uma arte com o nome do pokemon para imprimir
        if (!arquivo.exists()) {
            return;
        }

        System.out.println("\n");
        FileTools.printFile(nomeArquivo);
        System.out.println("\n");
    }

    /**
     * Lista os itens presentes no inventário do jogador
     * @throws FileNotFoundException se o arquivo não existir
     */
    public void listarItens() throws FileNotFoundException {
        while (true) {
            if (this.Inventario.isEmpty()) {
                System.out.println("🎒 Sua mochila está vazia. Passe na loja!");
                System.out.println("\uD83D\uDCB0 Quantidade de moedas: " + this.moedas);
                return;
            }

            System.out.println("\n" + ConsoleColors.CYAN_BOLD + "-------- INVENTÁRIO --------" + ConsoleColors.RESET);
            System.out.println("\uD83E\uDE99 Quantidade de moedas: " + this.moedas + "$");
            int i = 1;
            for (Item item : this.Inventario) {
                System.out.println(i + ". " + item.getNome() +": "+ item.getDescEfeito());
                i++;
            }
            System.out.println("0. Voltar"); // porque não sei quantos itens o usuário vai ter
            System.out.print("Escolha o número do item para usar (ou 0 para voltar): ");

            Scanner jogador = new Scanner(System.in);
            int escolha = -1;

            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }
            if (escolha == 0) {
                return;
            }  else if (escolha > 0 && escolha <= this.Inventario.size()) {
                Item itemEscolhido = this.Inventario.get(escolha - 1); // porque no ArrayList o item 1 está no índice 0
                usarItem(itemEscolhido);
            } else {
                System.out.println("⚠️ Escolha inválida!");
            }
        }
    }

    /**
     * Função individual com o inventário para o torneio
     * @throws FileNotFoundException se o arquivo não existir
     */
    public void inventarioTorneio() throws FileNotFoundException {
        while (true) {
            if (this.Inventario.isEmpty()) {
                System.out.println("🎒 Sua mochila está vazia. Passe na loja!");
                System.out.println("\uD83D\uDCB0 Quantidade de moedas: " + this.moedas);
                return;
            }

            System.out.println("\n" + ConsoleColors.CYAN_BOLD + "-------- INVENTÁRIO --------" + ConsoleColors.RESET);
            System.out.println("\uD83E\uDE99 Quantidade de moedas: " + this.moedas + "$");
            int i = 1;
            for (Item item : this.Inventario) {
                System.out.println(i + ". " + item.getNome() +": "+ item.getDescEfeito());
                i++;
            }
            System.out.println("0. Voltar"); // porque não sei quantos itens o usuário vai ter
            System.out.print("Escolha o número do item para usar (ou 0 para voltar): ");

            Scanner jogador = new Scanner(System.in);
            int escolha = -1;

            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }
            if (escolha == 0) {
                return;
            }  else if (escolha > 0 && escolha <= this.Inventario.size()) {
                Item itemEscolhido = this.Inventario.get(escolha - 1); // porque no ArrayList o item 1 está no índice 0
                usarItem(itemEscolhido);
            } else {
                System.out.println("⚠️ Escolha inválida!");
            }
        }
    }

    /**
     * Função para adicionar ‘item’ ao inventário
     * @param item comprado na loja ou ‘item’ encontrado no mapa
     */
    public void adcItemInventario(Item item) {
        Inventario.add(item);
        System.out.println(item.getNome() + " foi adicionado à mochila!");
    }

    /**
     * Função para adicionar moedas após o treino
     * @param quantidade ganha após vencer a batalha
     */
    public void adicionarMoedas(int quantidade) {
        this.moedas += quantidade;
        System.out.println("💰 Ganhou " + quantidade + " moedas! Saldo atual: " + this.moedas + "$");
    }

    /**
     * Função para verificar se tem moedas suficientes e comprar itens na loja
     * @param itemComprado na loja
     */
    public void comprarItem(Item itemComprado) {
        if(this.moedas >= itemComprado.getPreco()) {
            this.moedas -= itemComprado.getPreco();
            System.out.println("Você comprou 1un do item " + itemComprado.getNome());
            this.Inventario.add(itemComprado);
            System.out.println(" \uD83E\uDE99 Saldo restante: " + this.moedas + "$");
        } else {
            System.out.println("Você não tem moedas suficientes para realizar a compra! Ganhe batalhas treinando e receba \uD83D\uDCB0! ");
        }
    }

    /**
     * Função que permite utilizar um ‘item’ e removê-lo do inventário após o uso
     * @param itemUsado disponível no inventário
     * @throws FileNotFoundException se o arquivo não existir
     */
    public void usarItem(Item itemUsado) throws FileNotFoundException {

        if (!this.Inventario.contains(itemUsado)) {
            System.out.println("Ops, você não possui esse item :(");
            return;
        }

        if (itemUsado.getItem() == TipoItem.CURA) {
            int valorCura = itemUsado.getEfeito();
            if (this.hpAtual + valorCura > this.hpMax) {
                int curaReal = this.hpMax - this.hpAtual;
                this.hpAtual = this.hpMax;
                System.out.println("💖 " + this.nome + " recuperou " + curaReal + " HP (Vida Cheia!)");
                this.status = Status.FELIZ;
            } else {
                this.hpAtual += valorCura;
                System.out.println("💖 " + this.nome + " recuperou " + valorCura + " HP!");
            }
        } else if (itemUsado.getItem() == TipoItem.ATAQUE) {
                this.ataque += itemUsado.getEfeito();
                System.out.println("⚔️ Ataque aumentado em " + itemUsado.getEfeito() + "!");

        } else if (itemUsado.getItem() == TipoItem.DEFESA) {
                this.defesa += itemUsado.getEfeito();
                System.out.println("🛡️ Defesa aumentada em " + itemUsado.getEfeito() + "!");

        } else if (itemUsado.getItem() == TipoItem.NIVEL) {
            subirDeNivel();

        } else {
            System.out.println("Item desconhecido ou sem efeito.");
        }
        this.Inventario.remove(itemUsado);
    }
}