package Pokegotchi;

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
                FormaEvolutiva blastoise = new FormaEvolutiva("Blastoise", 100, 100, 36, TipoPokemon.AGUA, null);
                FormaEvolutiva wartortle = new FormaEvolutiva("Wartortle", 60, 60, 16, TipoPokemon.AGUA, blastoise);
                formaInicial = new FormaEvolutiva("Squirtle", 30, 30, 1, TipoPokemon.AGUA, wartortle);
                break;

            case 2: // Fogo
                tipoEscolhido = TipoPokemon.FOGO;
                nomePokemon = "Charmander";
<<<<<<< HEAD
                FormaEvolutiva megaCharizard = new FormaEvolutiva("Mega Charizard", 130, 90, 100, TipoPokemon.FOGO, null);
=======

                FormaEvolutiva megaCharizard = new FormaEvolutiva("Mega Charizard X", 130, 90, 100, TipoPokemon.FOGO, null);
>>>>>>> d8d6bef14dba8899325ba376c662e3ca65c6a7cb
                FormaEvolutiva charizard = new FormaEvolutiva("Charizard", 110, 80, 36, TipoPokemon.FOGO, megaCharizard);
                FormaEvolutiva charmeleon = new FormaEvolutiva("Charmeleon", 70, 50, 16, TipoPokemon.FOGO, charizard);
                formaInicial = new FormaEvolutiva("Charmander", 40, 20, 1, TipoPokemon.FOGO, charmeleon);
                break;
            case 3: // Terra
                tipoEscolhido = TipoPokemon.TERRA;
                nomePokemon = "Bulbasaur";
                FormaEvolutiva venusaur = new FormaEvolutiva("Venusaur", 110, 80, 36, TipoPokemon.TERRA, null);
                FormaEvolutiva ivysaur = new FormaEvolutiva("Ivysaur", 80, 70, 16, TipoPokemon.TERRA, venusaur);
                formaInicial = new FormaEvolutiva("Bulbasaur", 50, 30, 1, TipoPokemon.TERRA, ivysaur);
                break;

            default:
                System.out.println("Ops, opção inválida! Eu escolho por você!");
<<<<<<< HEAD
                tipoEscolhido = TipoPokemon.NORMAL;
                nomePokemon = "Ditto";
                formaInicial = new FormaEvolutiva("Pikachu", 10, 10, 1, TipoPokemon.ELETRICO);
=======
                tipoEscolhido = TipoPokemon.ELETRICO;
                nomePokemon = "Ditto";
                FormaEvolutiva r = new FormaEvolutiva("Raichu", 120, 70, 30, TipoPokemon.ELETRICO, null);
                formaInicial = new FormaEvolutiva("Pikachu", 50, 30, 1, TipoPokemon.ELETRICO, r);
>>>>>>> d8d6bef14dba8899325ba376c662e3ca65c6a7cb
                break;
        }

            this.pokemon = new PokemonEscolhido(
                tipoEscolhido,
                nomePokemon,
                1,   // Level
                0,   // XP
                20,  // HP Atual
                20,  // HP Max
                0,   // Fome
                100, // Energia
                Status.FELIZ,
                formaInicial,
                100  // Moedas
        );

        System.out.println("\nPARABÉNS!");
        System.out.println("Você escolheu o " + nomePokemon + "!");
        System.out.println("Ataque inicial: " + this.pokemon.getFormaAtual().getAtaqueBase());
        System.out.println("XP Atual: " + this.pokemon.ge;
        System.out.println("Defesa inicial: " + this.pokemon.getFormaAtual().getDefesaBase());
        System.out.println("A jornada começa agora...");
    }
}