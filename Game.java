package Pokegotchi;

import Pokegotchi.Enum.Mapa;
import Pokegotchi.Pokemons.NPCPokemon;
import Pokegotchi.Pokemons.PokemonEscolhido;
import Pokegotchi.Enum.TipoPokemon;
import Pokegotchi.Enum.Status;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private String nomeJogador;
    private PokemonEscolhido pokemon;
    private static ArrayList<NPCPokemon> pokemonTorneio;
    private Scanner jogador;
    private Loja loja;

    public Game() {
        this.jogador = new Scanner(System.in);
        this.pokemonTorneio = new ArrayList<>();
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.LUTA, "Mega Lucario", 10, 100, 100, 55, 40, 80));
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.AGUA, "Suicune", 10, 100, 105, 60, 40, 85));
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.GELO, "Articuno", 10, 100, 110, 65, 45, 90));
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.PSIQUICO, "Mewtwo X", 10, 100, 160, 90, 90, 100));
        this.loja = new Loja();
    }

    /**
     * Função que tem o menu iniciar o jogo
     *
     * @throws FileNotFoundException
     */
    public void iniciar() throws FileNotFoundException, InterruptedException {
        Audio.playMusic("AudioFiles/pokemon_theme.wav");

        System.out.println(ConsoleColors.YELLOW_BRIGHT + "                                   ,'\\\n" +
                "    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
                "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
                "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
                " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
                "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
                "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
                "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
                "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
                "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
                "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
                "                                `'                            '-._|  \n" +
                "\n" + ConsoleColors.RESET +
                "                        POKÉMON: ASCENSÃO DE UM CAMPEÃO\n");
        System.out.println("1. Jogar");
        System.out.println("2. Sair");
        System.out.print("Escolha uma opção: ");

        if (jogador.hasNextInt()) {
            int opcao = jogador.nextInt();
            jogador.nextLine();

            if (opcao == 1) {
                iniciarJogo();
            } else {
                Audio.stopMusic();
                Audio.playMusic("AudioFiles/pikachu_cry.wav");
                System.out.println("Já vai? Que pena! Até a próxima!\n" + ConsoleColors.YELLOW_BRIGHT + "⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿\n" +
                        "⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿\n" +
                        "⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿\n" +
                        "⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿\n" +
                        "⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿\n" +
                        "⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿\n" +
                        "⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿\n" +
                        "⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿\n" +
                        "⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿");
                Thread.sleep(3400);
            }
        } else {
            System.out.println("Entrada inválida. Tente outra opção.");
        }
    }

    /**
     * Função com menu de escolha do nome do jogador e escolher pokemon
     *
     * @throws FileNotFoundException
     */
    public void iniciarJogo() throws FileNotFoundException, InterruptedException {
        System.out.println("\n--------------------------------");
        System.out.println(ConsoleColors.WHITE_BOLD + """
                Bem-vindo ao mundo de Aurorium. Aqui, força e vínculo caminham lado a lado.
                Você, um jovem iniciante que sempre sonhou em participar da Liga de Aurorium, finalmente chega ao laboratório local.\s
                Seu objetivo inicial é simples: escolher o elemento que definirá sua rota de evolução — água, fogo ou terra.""" + ConsoleColors.RESET);
        System.out.print("Primeiro, me diz, qual é o seu nome? ");
        this.nomeJogador = jogador.nextLine();
        System.out.println("Prazer em te conhecer, " + this.nomeJogador + "!" + "\n");
        System.out.println("Agora é a hora de escolher seu parceiro:");
        System.out.println("1. Pokébola" + ConsoleColors.BLUE_BOLD + " (Elemento Água)" + ConsoleColors.RESET);
        System.out.println("2. Pokébola" + ConsoleColors.RED_BOLD + " (Elemento Fogo)" + ConsoleColors.RESET);
        System.out.println("3. Pokébola" + ConsoleColors.GREEN_BOLD + " (Elemento Terra)" + ConsoleColors.RESET);
        System.out.print("Qual elemento você prefere? (1-3): ");

        int escolha = 0;
        if (jogador.hasNextInt()) {
            escolha = jogador.nextInt();
        }
        iniciarPokemon(escolha);
    }

    /**
     * Funcao que determina as caracteristicas do pokemon escolhido de acordo com o tipo
     *
     * @param escolha
     * @throws FileNotFoundException
     */
    public void iniciarPokemon(int escolha) throws FileNotFoundException, InterruptedException {
        Audio.stopMusic();
        TipoPokemon tipoEscolhido = null;
        String nomePokemon = "";
        FormaEvolutiva formaInicial = null;

        switch (escolha) {
            case 1:
                Audio.playMusic("AudioFiles/squirtle.wav");
                tipoEscolhido = TipoPokemon.AGUA;
                nomePokemon = "Squirtle";

                FormaEvolutiva blastoise = new FormaEvolutiva("Blastoise", 80, 90, 70, 96, 8, TipoPokemon.AGUA, null);
                FormaEvolutiva wartortle = new FormaEvolutiva("Wartortle", 60, 90, 60, 80, 4, TipoPokemon.AGUA, blastoise);
                formaInicial = new FormaEvolutiva("Squirtle", 40, 50, 30, 60, 1, TipoPokemon.AGUA, wartortle);
                break;
            case 2:
                Audio.playMusic("AudioFiles/charmander.wav");
                tipoEscolhido = TipoPokemon.FOGO;
                nomePokemon = "Charmander";

                FormaEvolutiva megaCharizard = new FormaEvolutiva("Mega Charizard Y", 120, 130, 70, 100, 10, TipoPokemon.FOGO, null);
                FormaEvolutiva charizard = new FormaEvolutiva("Charizard", 80, 110, 50, 90, 8, TipoPokemon.FOGO, megaCharizard);
                FormaEvolutiva charmeleon = new FormaEvolutiva("Charmeleon", 50, 90, 40, 70, 4, TipoPokemon.FOGO, charizard);
                formaInicial = new FormaEvolutiva("Charmander", 45, 60, 25, 50, 1, TipoPokemon.FOGO, charmeleon);
                break;
            case 3:
                Audio.playMusic("AudioFiles/bulbasaur.wav");
                tipoEscolhido = TipoPokemon.TERRA;
                nomePokemon = "Bulbasaur";

                FormaEvolutiva venusaur = new FormaEvolutiva("Venusaur", 90, 100, 60, 100, 8, TipoPokemon.TERRA, null);
                FormaEvolutiva ivysaur = new FormaEvolutiva("Ivysaur", 60, 90, 50, 90, 4, TipoPokemon.TERRA, venusaur);
                formaInicial = new FormaEvolutiva("Bulbasaur", 35, 40, 30, 40, 1, TipoPokemon.TERRA, ivysaur);
                break;
            default:
                System.out.println("Ops, opção inválida! Eu escolho por você!");
                Audio.playMusic("AudioFiles/ditto.wav");
                tipoEscolhido = TipoPokemon.NORMAL;
                nomePokemon = "Ditto";
                formaInicial = new FormaEvolutiva("Ditto", 20, 25, 10, 15, 1, TipoPokemon.NORMAL, null);
                break;
        }

        this.pokemon = new PokemonEscolhido(tipoEscolhido, nomePokemon, 1, 0, 100, 100, Status.FELIZ, formaInicial, 100);

        System.out.println("PARABÉNS!");
        System.out.println("Você escolheu o " + nomePokemon + "!");
        this.pokemon.imprimirArtePokemon();
        this.pokemon.exibirDetalhesPoke();
        System.out.println("Quantidade de moedas: " + this.pokemon.getMoedas());
        System.out.println("Sua jornada começa agora...");

        menuPrincipal();
    }

    /**
     * Função com menu principal de açoes: explorar, treinar, loja ou sair
     *
     * @throws FileNotFoundException
     */
    public void menuPrincipal() throws FileNotFoundException, InterruptedException {
        while (true) {
            System.out.println(ConsoleColors.WHITE_BOLD + "\n-------- MENU PRINCIPAL --------" + ConsoleColors.RESET);
            System.out.println("Por onde começamos?");
            System.out.println("1. Explorar");
            System.out.println("2. Treinar");
            System.out.println("3. Ir à Loja");
            System.out.println("4. Inventário");
            System.out.println("5. Exibir Status do meu Pokémon");
            System.out.println("6. Sair do jogo");
            System.out.print("Escolha: ");
            int escolha = 0;

            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }

            switch (escolha) {
                case 1:
                    menuExplorar();
                    break;
                case 2:
                    treinar();
                    break;
                case 3:
                    visitarLoja();
                    break;
                case 4:
                    pokemon.listarItens();
                    break;
                case 5:
                    pokemon.exibirDetalhesPoke();
                    break;
                case 6:
                    Audio.playMusic("AudioFiles/pikachu_cry.wav");
                    System.out.println("Já vai? Que pena! Até a próxima!\n" + ConsoleColors.YELLOW_BRIGHT + "⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿\n" +
                            "⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿\n" +
                            "⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿\n" +
                            "⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿\n" +
                            "⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿\n" +
                            "⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿\n" +
                            "⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿\n" +
                            "⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿\n" +
                            "⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿\n" +
                            "⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿\n" +
                            "⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿");
                    Thread.sleep(3400);
                    return;
                default:
                    System.out.println("⚠️ Opção inválida!");
                    break;
            }
        }
    }

    /**
     * Funçao com menu de exploraçao para Floresta, Vulcão, Lago ou Usina
     *
     * @throws FileNotFoundException
     */
    public void menuExplorar() throws FileNotFoundException, InterruptedException {
        while (true) {
            System.out.println("\n------- MAPA DE EXPLORAÇÃO -------");
            System.out.println("Para onde deseja viajar?");
            System.out.println("1. Floresta Viridian");
            System.out.println("2. Vulcão Cinnabar");
            System.out.println("3. Lago da Fúria");
            System.out.println("4. Usina de Choque");
            System.out.println("5. Voltar");
            System.out.print("Escolha sua rota (1-5): ");

            int escolha = 0;

            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }

            Mapa mapaEscolhido = null;

            switch (escolha) {
                case 1:
                    mapaEscolhido = Mapa.FLORESTA;
                    break;
                case 2:
                    mapaEscolhido = Mapa.VULCAO;
                    break;
                case 3:
                    mapaEscolhido = Mapa.LAGO;
                    break;
                case 4:
                    mapaEscolhido = Mapa.USINA;
                    break;
                case 5:
                    return;
                default:
                    System.out.println("⚠️ Esse local não existe no mapa! Tente de novo.");
                    continue; // Volta para o início do loop
            }
            System.out.println("Viajando para " + mapaEscolhido.getNome());
            iniciarExploracao(mapaEscolhido);
        }
    }

    /**
     * Menu que de acordo com o mapa escolhido pode encontrar pokemons selvagens, pocoes ou nada acontece.
     * @param mapa escolhido no menu anterior
     * @throws FileNotFoundException
     */
    public void iniciarExploracao(Mapa mapa) throws FileNotFoundException, InterruptedException {

        // Função de probalidade de encontro com pokemon selvagem
        Random rd = new Random();
        int encontrarInimigo = rd.nextInt(100);

        if (encontrarInimigo < 70) {

            TipoPokemon tipoDoLocal = mapa.getTipoInimigo();
            int nivelInimigo = pokemon.getLevel();
            String nomeInimigo = "";
            int hpBase = 0;
            int atkBase = 0;
            int defBase = 0;

            switch (tipoDoLocal) {
                case FOGO:
                    nomeInimigo = "Ponyta";
                    hpBase = 100; atkBase = 40; defBase = 30;
                    break;
                case AGUA:
                    nomeInimigo = "Gyarados";
                    hpBase = 100; atkBase = 35; defBase = 25;
                    break;
                case TERRA:
                    nomeInimigo = "Diglett";
                    hpBase = 100; atkBase = 35; defBase = 30;
                    break;
                case ELETRICO:
                    nomeInimigo = "Pichu";
                    hpBase = 100; atkBase = 40; defBase = 35;
                    break;
                default:
                    nomeInimigo = "Ditto Perdido";
                    hpBase = 100; atkBase = 30; defBase = 20;
                    break;
            }

            NPCPokemon inimigo = new NPCPokemon(tipoDoLocal,nomeInimigo,nivelInimigo, hpBase,atkBase +(2*nivelInimigo),atkBase +2 + (2*nivelInimigo), defBase + (2*nivelInimigo), defBase + +2 + (2*nivelInimigo));

            System.out.println("\n⚔️ CUIDADO! Um " + inimigo.getNome() + " (Nvl " + nivelInimigo + ") apareceu!");
            System.out.println("HP: " + inimigo.getHpMax() + " | Atk: " + inimigo.getAtaque() + " | Def: " + inimigo.getDefesa());

            while (true) {
                System.out.println("\nO que você vai fazer?");
                System.out.println("1. Batalhar!");
                System.out.println("2. Tentar Fugir");
                System.out.println("3. Verificar Status do meu Pokemon");
                System.out.print("Faça sua escolha: ");

                int decisao = 0;
                if (jogador.hasNextInt()) {
                    decisao = jogador.nextInt();
                }

                if (decisao == 1) {
                    System.out.println("\nVocê decidiu batalhar, boa sorte!");
                    batalhar(inimigo);
                    break;
                }
                else if (decisao == 2) {
                    tentarFugir(inimigo);
                    break;
                }
                else if (decisao == 3) {
                    pokemon.exibirDetalhesPoke();
                }
                else {
                    System.out.println("Você ficou paralisado de medo... A batalha começou!");
                    batalhar(inimigo);
                    break;
                }
            }
        } else if (encontrarInimigo < 90){
            System.out.println("\n🍃 Você caminhou pelo " + mapa.getNome() + " e encontrou um item");
            Item pocaoEncontrada = new Item("Poção de cura" , Pokegotchi.Enum.TipoItem.CURA, 0.0, "Recupera 20 HP",20);
            System.out.println("Obteve: " + pocaoEncontrada.getNome());
            pokemon.adcItemInventario(pocaoEncontrada);
        } else {
            System.out.println("\n🍃 Você caminhou pelo " + mapa.getNome() + " e estava tudo tranquilo.");
        }
    }

    /**
     * Funçao principal da batalha para verificar vitória ou derrota baseado no HP
     * @param inimigo
     * @throws FileNotFoundException
     */
    public void batalhar(NPCPokemon inimigo) throws FileNotFoundException, InterruptedException {

        while(pokemon.getHpAtual() > 0 && inimigo.getHpAtual() > 0) {
            // condição para saber se derrotou o NPC inimigo
            boolean vitoria = pokemon.atacar(inimigo);

            if(vitoria) {
                System.out.println("🏆 Você venceu o " + inimigo.getNome() + "!");
                pokemon.ganharXP(40);

                if (pokemon.getLevel() == 9) {
                    System.out.println("\n🏟️ Você se qualificou para o Torneio!");
                    menuTorneio();
                }
            }

            if (inimigo.getHpAtual() > 0) {
                System.out.println("\n🔻 " + inimigo.getNome() + " contra-ataca!");

                int danoInimigo = inimigo.getAtaque() - pokemon.getDefesa();

                if (danoInimigo <= 0) {
                    System.out.println("Sua defesa absorveu quase todo o impacto!");
                    danoInimigo = 3;
                }
                System.out.println("O inimigo causou " + danoInimigo + " de dano!");
                pokemon.receberDano(danoInimigo);
            }
        }
    }

    /**
     * Funçao que possibilita treinar com pokemons específicos e ganhar moedas se vencer
     * @throws FileNotFoundException
     */
    public void treinar() throws FileNotFoundException, InterruptedException {
        System.out.println("\n--- CAMPO DE TREINAMENTO ---");
        System.out.println("Escolha seu parceiro de treino");
        System.out.println("1. Cinderace");
        System.out.println("2. Lapras");
        System.out.println("3. Pikachu");
        System.out.println("4. Psyduck");
        System.out.println("5. Voltar");
        System.out.print("Sua escolha: ");

        int escolha = 0;
        if (jogador.hasNextInt()) {
            escolha = jogador.nextInt();
            jogador.nextLine();
        }

        int nivelTreino = pokemon.getLevel();

        String parceiroTreino = "Gardevoir";
        TipoPokemon tipoParceiro = TipoPokemon.PSIQUICO;

        switch (escolha) {
            case 1:
                parceiroTreino = "Cinderace";
                tipoParceiro = TipoPokemon.FOGO;
                break;
            case 2:
                parceiroTreino = "Lapras";
                tipoParceiro = TipoPokemon.AGUA;
                break;
            case 3:
                parceiroTreino = "Pikachu";
                tipoParceiro = TipoPokemon.ELETRICO;
                break;
            case 4:
                parceiroTreino = "Psyduck";
                break;
            case 5:
                menuPrincipal();
            default:
                System.out.println("Escolha inválida! Não se preocupe, eu escolhi seu parceiro!");
                break;
        }

        System.out.println("Iniciando treino contra " + parceiroTreino + "...");

        NPCPokemon poketreino = new NPCPokemon( tipoParceiro, parceiroTreino, nivelTreino, 100, 30 + (nivelTreino * 2), 40 + (nivelTreino * 2), 30, 35 + (nivelTreino * 2));

        batalhar(poketreino);
        pokemon.adicionarMoedas(35);
        System.out.println("O treino acabou! Seu Pokémon ganhou mais experiencia(XP).");
    }

    /**
     * Função que determina 50% de probabilidade de escapar de uma batalha
     * @param inimigo
     * @throws FileNotFoundException
     */
    public void tentarFugir(NPCPokemon inimigo) throws FileNotFoundException, InterruptedException {
        System.out.println("Tentando escapar...");
        Random rd = new Random();
        int sorteFuga = rd.nextInt(100);

        if (sorteFuga < 50) {
            System.out.println("💨 SUCESSO! Você fugiu com o rabo entre as pernas.");
        } else {
            System.out.println("🚫 FALHOU! O " + inimigo.getNome() + " bloqueou sua passagem e agora terá que lutar!");
            batalhar(inimigo);
        }
    }

    /**
     * Função para ir à loja comprar itens
     */
    public void visitarLoja() {
        System.out.println("\n--- BEM-VINDO À POKÉLOJA ---");
        System.out.println("Saldo Atual: " + pokemon.getMoedas() + "$");

        loja.exibirEstoque();

        System.out.println("0. Sair da Loja");
        System.out.print("Digite o número do item que quer comprar: ");

        int escolha = -1;
        if (jogador.hasNextInt()) {
            escolha = jogador.nextInt();
        }

        if (escolha > 0) {
            Item itemDesejado = loja.getEstoque().get(escolha-1);
            if (itemDesejado != null) {
                pokemon.comprarItem(itemDesejado);
            } else {
                System.out.println("Item não encontrado!");
            }
        } else {
            System.out.println("Saindo da loja...");
        }
    }

    /**
     * Função com menu pré-batalha no torneio
     * @throws FileNotFoundException
     */
    public void menuTorneio() throws FileNotFoundException, InterruptedException {
        System.out.println("""
                Após jornadas árduas, treinamentos incansáveis e batalhas que moldaram seu espírito, 
                você finalmente alcança o ponto máximo de sua trajetória: o grande Torneio de Aurorium.

                Treinadores de todos os cantos se reúnem, cada um trazendo sua própria história,
                seus desafios, suas vitórias — e agora, você está entre eles.

                Seja bem-vindo ao Torneio de Aurorium.
                Que sua força brilhe mais do que qualquer cristal desta arena.
                O mundo inteiro está prestes a ver do que você é capaz.
                """);

        boolean iniciarTorneio = false;

        while(!iniciarTorneio) {

            System.out.println("\n1. Iniciar Torneio");
            System.out.println("2. Abrir inventário");
            System.out.println("3. Ver status do Pokémon");

            int escolha = jogador.nextInt();

            switch (escolha) {
                case 1:
                    torneioPokemon();
                    iniciarTorneio = true;
                    break;
                case 2:
                    pokemon.inventarioTorneio();
                    break;
                case 3:
                    pokemon.exibirDetalhesPoke();
                    break;
                default:
                    System.out.println("⚠️ Opção inválida!");
                    break;
            }
        }
    }

    /**
     * Função que determina as rodadas e adversários do torneio
     * @throws FileNotFoundException
     */
    public void torneioPokemon() throws FileNotFoundException, InterruptedException {

        for (int i = 0; i < pokemonTorneio.size(); i++) {
            NPCPokemon adversario = pokemonTorneio.get(i);

            System.out.println("\n⚔️ RODADA " + (i + 1) + ": Seu adversário é " + adversario.getNome());

            batalhar(adversario);

            if (pokemon.getHpAtual() <= 0) {
                System.out.println("❌ O teu Pokémon não resistiu. Foste eliminado do torneio.");
                return;
            }

            System.out.println("✅ Vitória contra " + adversario.getNome() + "!");

            if (i == pokemonTorneio.size() - 1) {
                Audio.playMusic("AudioFiles/pokemon_theme.wav");
                System.out.println("\n🏆 PARABÉNS! ÉS O NOVO" + ConsoleColors.YELLOW_BRIGHT + " CAMPEÃO DE AURORIUM!" + ConsoleColors.RESET);
                System.out.println("🏆 Como recompensa, podes ir ao laboratório" + ConsoleColors.GREEN_BACKGROUND_BRIGHT + " criar um novo Pokémon!" + ConsoleColors.RESET);
                criarPokemon();
                return;
            }

            pokemon.adicionarMoedas(60);
            System.out.println("Aproveita para recuperar teu pokémon antes da próxima batalha...");
            menuIntervaloTorneio();
        }
    }

    /**
     * Função com menu de intervalo entre as rodadas do torneio
     * @throws FileNotFoundException
     */
    private void menuIntervaloTorneio() throws FileNotFoundException {
        boolean continuarBatalha = false;
        while (!continuarBatalha) {
            System.out.println("\n--- INTERVALO DO TORNEIO ---");
            System.out.println("1. Próxima Batalha");
            System.out.println("2. Inventário");
            System.out.println("3. Ir à Loja");
            System.out.println("4. Ver Status do meu Pokémon");
            System.out.print("Escolha: ");

            int escolha = 0;
            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
                jogador.nextLine();
            }

            switch (escolha) {
                case 1:
                    continuarBatalha = true;
                    break;
                case 2:
                    pokemon.inventarioTorneio();
                    break;
                case 3:
                    visitarLoja();
                    break;
                case 4:
                    pokemon.exibirDetalhesPoke();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    /**
     * Função que possibilita a criação de pokemon a escolha do jogador e reiniciar o jogo com o pokemon novo
     * @throws FileNotFoundException
     */
    public void criarPokemon() throws FileNotFoundException, InterruptedException {

        System.out.println("\n------------------------------------------------");
        System.out.println("Olá, " + nomeJogador + "! Como prêmio do Torneio, você pode criar um novo parceiro!");

        TipoPokemon tipoEscolhido = null;

        while (tipoEscolhido == null) {
            System.out.println("\nEscolha o Tipo do Pokémon:");
            System.out.println("1. Água");
            System.out.println("2. Fogo");
            System.out.println("3. Terra");
            System.out.println("4. Elétrico");
            System.out.println("5. Psíquico");
            System.out.println("6. Luta");
            System.out.print("Sua escolha: ");

            int escolha = 0;
            escolha = jogador.nextInt();

            switch (escolha) {
                case 1:
                    tipoEscolhido = TipoPokemon.AGUA;
                    break;
                case 2:
                    tipoEscolhido = TipoPokemon.FOGO;
                    break;
                case 3:
                    tipoEscolhido = TipoPokemon.TERRA;
                    break;
                case 4:
                    tipoEscolhido = TipoPokemon.ELETRICO;
                    break;
                case 5:
                    tipoEscolhido = TipoPokemon.PSIQUICO;
                    break;
                case 6:
                    tipoEscolhido = TipoPokemon.LUTA;
                    break;
                default:
                    System.out.println("⚠️ Tipo inválido!");
                    return;
            }
        }

        int atkBasico, atkEspecial, defBasica, defEspecial;
        String nomeNovo;

        do {
            System.out.println("\nDistribua os atributos (valores entre 10 e 60):");
            System.out.print("Ataque básico: ");
            atkBasico = jogador.nextInt();

            System.out.print("Ataque especial: ");
            atkEspecial = jogador.nextInt();

            System.out.print("Defesa básica: ");
            defBasica = jogador.nextInt();

            System.out.print("Defesa especial: ");
            defEspecial = jogador.nextInt();

            System.out.print("\nNome do Pokémon: ");
            jogador.nextLine();
            nomeNovo = jogador.nextLine();

            if (atkBasico < 10 || atkBasico > 80 ||
                    atkEspecial < 10 || atkEspecial > 80 ||
                    defBasica < 10 || defBasica > 80 ||
                    defEspecial < 10 || defEspecial > 80) {

                System.out.println("⚠️ Todos os atributos devem estar entre 10 e 60.");
            }

        } while (
                atkBasico < 10 || atkBasico > 60
                        || atkEspecial < 10 || atkEspecial > 60
                        || defBasica < 10 || defBasica > 60 ||
                        defEspecial < 10 || defEspecial > 60
        );

        FormaEvolutiva evolucao2 = new FormaEvolutiva(nomeNovo, atkBasico + 40, atkEspecial + 40, defBasica, defEspecial + 45, 8, tipoEscolhido, null);
        FormaEvolutiva evolucao1 = new FormaEvolutiva(nomeNovo, atkBasico + 10, atkEspecial +30, defBasica, defEspecial + 25, 4, tipoEscolhido, evolucao2);
        FormaEvolutiva formaInicial = new FormaEvolutiva( nomeNovo, atkBasico, atkEspecial, defBasica,defEspecial,1, tipoEscolhido,evolucao1);

        this.pokemon = new PokemonEscolhido(tipoEscolhido,nomeNovo,1,0,100,100,Status.FELIZ,formaInicial,100);

        System.out.println("\n✅ Pokémon " + nomeNovo + " criado com sucesso!");
        System.out.println("Uma nova jornada começa agora!");
        Audio.stopMusic();
        menuPrincipal();
    }
}