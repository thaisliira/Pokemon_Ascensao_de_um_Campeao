package Pokegotchi;

import Pokegotchi.Enum.Mapa;
import Pokegotchi.Pokemons.NPCPokemon;
import Pokegotchi.Pokemons.PokemonEscolhido;
import Pokegotchi.Enum.TipoPokemon;
import Pokegotchi.Enum.Status;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private String nomeJogador;
    private PokemonEscolhido pokemon;
    private ArrayList<NPCPokemon> selvagens;
    private ArrayList<NPCPokemon> pokemonTorneio;
    private int dia;
    private final int diaFinal;
    private Scanner jogador;

    public Game() {
        this.jogador = new Scanner(System.in);
        this.selvagens = new ArrayList<>();
        this.pokemonTorneio = new ArrayList<>();
        this.dia = 1;
        this.diaFinal = 50;
    }

    public void iniciar() {
        System.out.println("BEM-VINDO AO MUNDO POKÉGOTCHI!");
        System.out.println("1. Jogar");
        System.out.println("2. Sair");
        System.out.print("Escolha uma opção: ");

        if (jogador.hasNextInt()) {
            int opcao = jogador.nextInt();
            jogador.nextLine(); 

            if (opcao == 1) {
                iniciarJogo();
            } else {
                System.out.println("Já vai? Que pena! Até a próxima, mestre!");
                System.exit(0);
            }
        } else {
            System.out.println("Entrada inválida. Tente outra opção.");
        }
    }

    private void iniciarJogo() {
        System.out.println("\n--------------------------------");
        System.out.println("Olá, jovem treinador!");
        System.out.print("Primeiro, me diz, qual é o seu nome? ");
        this.nomeJogador = jogador.nextLine();
        System.out.println("\nPrazer em te conhecer, mestre " + this.nomeJogador + "!");

        System.out.println("\n---");
        System.out.println("Agora é a hora de escolher seu parceiro:");
        System.out.println("1. Pokebola (Elemento Água)");
        System.out.println("2. Pokebola (Elemento Fogo)");
        System.out.println("3. Pokebola (Elemento Terra)");
        System.out.print("Qual elemento você prefere? (1-3): ");

        int escolha = 0;
        if (jogador.hasNextInt()) {
            escolha = jogador.nextInt();
            jogador.nextLine();
        }

        iniciarPokemon(escolha);
    }

    private void iniciarPokemon(int escolha) {
        TipoPokemon tipoEscolhido = null;
        String nomePokemon = "";
        FormaEvolutiva formaInicial = null;

        switch (escolha) {
            case 1: // Água
                tipoEscolhido = TipoPokemon.AGUA;
                nomePokemon = "Squirtle";
                FormaEvolutiva blastoise = new FormaEvolutiva("Blastoise", 80, 90, 85, 96, 13, TipoPokemon.AGUA, null);
                FormaEvolutiva wartortle = new FormaEvolutiva("Wartortle", 60, 90, 60,80, 6, TipoPokemon.AGUA, blastoise);
                formaInicial = new FormaEvolutiva("Squirtle", 30, 50, 30,60, 1, TipoPokemon.AGUA, wartortle);
                break;

            case 2: // Fogo
                tipoEscolhido = TipoPokemon.FOGO;
                nomePokemon = "Charmander";

                FormaEvolutiva megaCharizard = new FormaEvolutiva("Mega Charizard", 120, 130, 100, 110, 13, TipoPokemon.FOGO, null);
                FormaEvolutiva charizard = new FormaEvolutiva("Charizard", 100, 110, 80, 90, 10, TipoPokemon.FOGO, megaCharizard);
                FormaEvolutiva charmeleon = new FormaEvolutiva("Charmeleon", 80, 90, 60, 70, 6, TipoPokemon.FOGO, charizard);
                formaInicial = new FormaEvolutiva("Charmander", 40, 60, 30, 50, 1, TipoPokemon.FOGO, charmeleon);
                break;
            case 3: // Terra
                tipoEscolhido = TipoPokemon.TERRA;
                nomePokemon = "Bulbasaur";
                FormaEvolutiva venusaur = new FormaEvolutiva("Venusaur", 90, 100, 90, 100, 10, TipoPokemon.TERRA, null);
                FormaEvolutiva ivysaur = new FormaEvolutiva("Ivysaur", 70, 90, 70, 90, 6, TipoPokemon.TERRA, venusaur);
                formaInicial = new FormaEvolutiva("Bulbasaur", 30, 40, 30,40, 1, TipoPokemon.TERRA,  ivysaur);
                break;

            default:
                System.out.println("Ops, opção inválida! Eu escolho por você!");

                tipoEscolhido = TipoPokemon.NORMAL;
                nomePokemon = "Ditto";
                formaInicial = new FormaEvolutiva("Ditto", 10, 10, 10, 10, 1, TipoPokemon.NORMAL, null);
                break;
        }

            this.pokemon = new PokemonEscolhido(
                tipoEscolhido,
                nomePokemon,
                1,   // Level
                0,   // XP
                100,  // HP Atual
                100,  // HP Max
                0,   // Fome
                100, // Energia
                Status.FELIZ,
                formaInicial,
                100  // Moedas
        );

        System.out.println("\nPARABÉNS!");
        System.out.println("Você escolheu o " + nomePokemon + "!");
        System.out.println("Dia atual: " + this.dia);
        System.out.println("HP atual: " + this.pokemon.getHpAtual());
        System.out.println("XP Atual: " + this.pokemon.getHpAtual());
        System.out.println("Ataque Básico: " + this.pokemon.getFormaAtual().getAtaqueBase());
        System.out.println("Defesa Básica: " + this.pokemon.getFormaAtual().getDefesaBase());
        System.out.println("Quantidade de moedas: " + this.pokemon.getMoedas());
        System.out.println("A jornada começa agora...");

        continuarJogo();
    }

    private void continuarJogo() {
        boolean jogando = true;
        while (jogando) {
            menuExplorar();
            break;
        }
    }

    private void menuExplorar() {
        System.out.println("\n--- MAPA DE EXPLORAÇÃO ---");
        System.out.println("Para onde deseja viajar?");
        System.out.println("1. Floresta Viridian");
        System.out.println("2. Vulcão em Chamas");
        System.out.println("3. Lago Sombrio");
        System.out.println("4. Usina Elétrica");
        System.out.print("Escolha sua rota (1-4): ");

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
            default:
                System.out.println("⚠️ Esse local não existe no mapa!");
                return;
        }

        if (mapaEscolhido != null) {
            System.out.println("Viajando para " + mapaEscolhido.getNome());
            iniciarExploracao(mapaEscolhido);
        }
    }

    private void iniciarExploracao(Mapa mapa) {
        int encontrarInimigo = new java.util.Random().nextInt(100);

        if (encontrarInimigo < 60) {

            TipoPokemon tipoDoLocal = mapa.getTipoInimigo();
            int nivelInimigo = (this.dia / 5) + 1;

            NPCPokemon inimigo = new NPCPokemon(
                    tipoDoLocal,
                    "Selvagem do " + mapa.getNome(),
                    nivelInimigo,
                    30 + (nivelInimigo * 5), // HP Max
                    5 + nivelInimigo,        // Ataque Físico
                    6 + nivelInimigo,        // Ataque Especial (NOVO)
                    2,                       // Defesa Física
                    3                       // Defesa Especial (NOVO)
            );

            System.out.println("\n⚔️ CUIDADO! Um " + inimigo.getNome() + " (Nvl " + nivelInimigo + ") apareceu!");
            System.out.println("HP do Inimigo: " + inimigo.getHpMax());

            System.out.println("\nO que você vai fazer?");
            System.out.println("1. Batalhar!");
            System.out.println("2. Tentar Fugir");
            System.out.println("3. Verificar Status do Pokemon");
            System.out.print("Faça sua escolha: ");

            int escolhaAcao = 0;
            if (jogador.hasNextInt()) {
                escolhaAcao = jogador.nextInt();
                jogador.nextLine();
            }

            if (escolhaAcao == 1) {
                System.out.println("Você assumiu postura de combate!");
                batalhar(inimigo);
            }
            else if (escolhaAcao == 2) {
                tentarFugir(inimigo);
            }
            else if (escolhaAcao == 3) {
                pokemon.exibirDetalhesPoke();
            }
            else {
                System.out.println("Você ficou paralisado de medo... A batalha começou!");
                batalhar(inimigo);
            }

        } else {
            System.out.println("🍃 Você caminhou pelo " + mapa.getNome() + " e estava tudo tranquilo.");
        }
    }

    private void tentarFugir(NPCPokemon inimigo) {
        System.out.println("Tentando escapar...");
        int sorteFuga = new java.util.Random().nextInt(100);

        if (sorteFuga < 50) {
            System.out.println("💨 SUCESSO! Você fugiu com o rabo entre as pernas.");
        } else {
            System.out.println("🚫 FALHA! O " + inimigo.getNome() + " bloqueou sua passagem!");
            System.out.println("Você foi forçado a lutar!");
            batalhar(inimigo);
        }
    }

    private void batalhar(NPCPokemon inimigo) {
        System.out.println("--- Batalha Iniciada ---");
        while(pokemon.getHpAtual() > 0 && inimigo.getHpAtual() > 0) {
            // Seu turno
//            boolean vitoria = pokemon.atacar(inimigo);
//            if(vitoria) {
//                System.out.println("Você venceu!");
//                return;
//            }
//            inimigo.atacar(pokemon);
        }
    }
}