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
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.PSIQUICO, "Mewtwo X", 10, 100, 70, 75, 60, 65));
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.AGUA, "Suicune", 10, 100, 50, 60, 40, 50));
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.LUTA, "Mega Lucario", 10, 100, 45, 55, 40, 45));
        pokemonTorneio.add(new NPCPokemon(TipoPokemon.GELO, "Articuno", 10, 100, 55, 65, 45, 55));
        this.loja = new Loja();
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    /**
     * Função que tem o menu iniciar o jogo
     *
     * @throws FileNotFoundException
     */
    public void iniciar() throws FileNotFoundException {
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
                Audio.stopMusic();
                iniciarJogo();
            } else {
                System.out.println("Já vai? Que pena! Até a próxima!\n" + ConsoleColors.YELLOW_BRIGHT + "⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿\n" +
                        "⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿\n" +
                        "⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿\n" +
                        "⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿\n" +
                        "⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿\n" +
                        "⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿\n" +
                        "⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿\n" +
                        "⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀⢄⠀⢀⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿\n" +
                        "⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿\n" +
                        "⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿");
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
    public void iniciarJogo() throws FileNotFoundException {
        System.out.println("\n--------------------------------");
        System.out.println("""
                Bem-vindo ao mundo de Aurorium. Aqui, força e vínculo caminham lado a lado.
                Você, um jovem iniciante que sempre sonhou em participar da Liga de Aurorium, finalmente chega ao laboratório local.\s
                Seu objetivo inicial é simples: escolher o elemento que definirá sua rota de evolução — água, fogo ou terra.""");
        System.out.print("Primeiro, me diz, qual é o seu nome? ");
        this.nomeJogador = jogador.nextLine();
        System.out.println("Prazer em te conhecer, " + this.nomeJogador + "!" + "\n");
        System.out.println("Agora é a hora de escolher seu parceiro:");
        System.out.println("1. Pokébola (Elemento Água)");
        System.out.println("2. Pokébola (Elemento Fogo)");
        System.out.println("3. Pokébola (Elemento Terra)");
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
    public void iniciarPokemon(int escolha) throws FileNotFoundException {
        TipoPokemon tipoEscolhido = null;
        String nomePokemon = "";
        FormaEvolutiva formaInicial = null;

        switch (escolha) {
            case 1:
                Audio.playMusic("AudioFiles/squirtle.wav");
                tipoEscolhido = TipoPokemon.AGUA;
                nomePokemon = "Squirtle";

                FormaEvolutiva blastoise = new FormaEvolutiva("Blastoise", 80, 90, 70, 96, 13, TipoPokemon.AGUA, null);
                FormaEvolutiva wartortle = new FormaEvolutiva("Wartortle", 60, 90, 60, 80, 6, TipoPokemon.AGUA, blastoise);
                formaInicial = new FormaEvolutiva("Squirtle", 40, 50, 30, 60, 1, TipoPokemon.AGUA, wartortle);
                break;
            case 2:
                Audio.playMusic("AudioFiles/charmander.wav");
                tipoEscolhido = TipoPokemon.FOGO;
                nomePokemon = "Charmander";

                FormaEvolutiva megaCharizard = new FormaEvolutiva("Mega Charizard", 120, 130, 70, 110, 13, TipoPokemon.FOGO, null);
                FormaEvolutiva charizard = new FormaEvolutiva("Charizard", 80, 110, 50, 90, 10, TipoPokemon.FOGO, megaCharizard);
                FormaEvolutiva charmeleon = new FormaEvolutiva("Charmeleon", 50, 90, 40, 70, 6, TipoPokemon.FOGO, charizard);
                formaInicial = new FormaEvolutiva("Charmander", 45, 60, 25, 50, 1, TipoPokemon.FOGO, charmeleon);
                break;
            case 3:
                Audio.playMusic("AudioFiles/bulbasaur.wav");
                tipoEscolhido = TipoPokemon.TERRA;
                nomePokemon = "Bulbasaur";

                FormaEvolutiva venusaur = new FormaEvolutiva("Venusaur", 90, 100, 60, 100, 10, TipoPokemon.TERRA, null);
                FormaEvolutiva ivysaur = new FormaEvolutiva("Ivysaur", 60, 90, 50, 90, 6, TipoPokemon.TERRA, venusaur);
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
    public void menuPrincipal() throws FileNotFoundException {
        while (true) {
            System.out.println("\n-------- MENU PRINCIPAL --------");
            System.out.println("Por onde começamos?");
            System.out.println("1. Explorar");
            System.out.println("2. Treinar");
            System.out.println("3. Ir à Loja");
            System.out.println("4. Inventário");
            System.out.println("5. Sair");
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
                    System.out.println("Já vai? Que pena! Até a próxima!\n" + ConsoleColors.YELLOW_BRIGHT + "⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿\n" +
                            "⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿\n" +
                            "⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿\n" +
                            "⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿\n" +
                            "⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿\n" +
                            "⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿\n" +
                            "⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿\n" +
                            "⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿\n" +
                            "⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀⢄⠀⢀⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿\n" +
                            "⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿\n" +
                            "⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿");
                    return;
                default:
                    System.out.println("⚠️ Opção inválida!");
            }
        }
    }

    /**
     * Funçao com menu de exploraçao para Floresta, Vulcão, Lago ou Usina
     *
     * @throws FileNotFoundException
     */
    public void menuExplorar() throws FileNotFoundException {
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
                    System.out.println("⚠️ Esse local não existe no mapa!");
                    break;
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
    public void iniciarExploracao(Mapa mapa) throws FileNotFoundException {

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
            Item pocaoEncontrada = new Item("Poção de cura", Pokegotchi.Enum.TipoItem.CURA, 0.0, "Recupera 20 HP",20);
            System.out.println("Obteve: " + pocaoEncontrada.getNome());
            pokemon.adcItemInventario(pocaoEncontrada);
        } else {
            System.out.println("\n🍃 Você caminhou pelo " + mapa.getNome() + " e estava tudo tranquilo.");
        }
    }

    public void batalhar(NPCPokemon inimigo) throws FileNotFoundException {

        while(pokemon.getHpAtual() > 0 && inimigo.getHpAtual() > 0) {

            // condição para saber se derrotou o NPC inimigo
            boolean vitoria = pokemon.atacar(inimigo);

            if(vitoria) {
                System.out.println("🏆 Você venceu o " + inimigo.getNome() + "!");
                boolean pronto = pokemon.ganharXP(40);

                if (pronto) {
                    torneioPokemon();
                }
                return;
            }

            if (inimigo.getHpAtual() > 0) {
                System.out.println("\n🔻 " + inimigo.getNome() + " contra-ataca!");

                int danoInimigo = inimigo.getAtaque() - pokemon.getDefesa();

                if (danoInimigo < 0) danoInimigo = 0;

                if (danoInimigo == 0) {
                    System.out.println("Sua defesa absorveu quase todo o impacto!");
                    danoInimigo = 3;
                }

                System.out.println("O inimigo causou " + danoInimigo + " de dano!");
                pokemon.receberDano(danoInimigo);

                if (pokemon.getHpAtual() <= 0) {
                    System.out.println("☠️ Seu Pokémon desmaiou...");
                }
            }
        }
        System.out.println("Seu pokemon nao pode batalhar, recupere a saúde dele, urgentemente!");
    }

    public void treinar() throws FileNotFoundException {
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
        pokemon.adicionarMoedas(30);
        System.out.println("O treino acabou! Seu Pokémon ganhou mais experiencia(XP).");
    }

    public void tentarFugir(NPCPokemon inimigo) throws FileNotFoundException {
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

    public void torneioPokemon() throws FileNotFoundException {
        NPCPokemon primeiroAdversario = pokemonTorneio.get(3);

        System.out.println("Seu primeiro adversário será: " + primeiroAdversario);
        batalhar(primeiroAdversario);
    }
}