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
    private Scanner jogador;

    public Game() {
        this.jogador = new Scanner(System.in);
        this.selvagens = new ArrayList<>();
        this.pokemonTorneio = new ArrayList<>();
        this.dia = 1;
    }

    public void iniciar() {
        System.out.println("BEM-VINDO AO MUNDO POKÉGOTCHI!");
        System.out.println("1. Jogar");
        System.out.println("2. Sair");
        System.out.print("Escolha: ");

        // Tratamento simples para evitar crash se digitar letra
        if (jogador.hasNextInt()) {
            int opcao = jogador.nextInt();
            jogador.nextLine(); // Limpar buffer

            if (opcao == 1) {
                criarSave();
            } else {
                System.out.println("Saindo...");
                System.exit(0);
            }
        } else {
            System.out.println("Entrada inválida. Reinicie.");
        }
    }

    private void criarSave() {
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

                FormaEvolutiva megaCharizard = new FormaEvolutiva("Mega Charizard", 130, 90, 100, TipoPokemon.FOGO, null);
                FormaEvolutiva charizard = new FormaEvolutiva("Charizard", 110, 80, 36, TipoPokemon.FOGO, megaCharizard);
                FormaEvolutiva charmeleon = new FormaEvolutiva("Charmeleon", 70, 50, 16, TipoPokemon.FOGO, charizard);
                formaInicial = new FormaEvolutiva("Charmander", 40, 20, 1, TipoPokemon.FOGO, charmeleon);
                break;

            case 3: // Terra
                tipoEscolhido = TipoPokemon.TERRA;
                nomePokemon = "Bulbasaur";

                // CORREÇÃO: Venusaur e Ivysaur são TERRA (ou GRASS), não FOGO.
                FormaEvolutiva venusaur = new FormaEvolutiva("Venusaur", 110, 80, 36, TipoPokemon.TERRA, null);
                FormaEvolutiva ivysaur = new FormaEvolutiva("Ivysaur", 80, 70, 16, TipoPokemon.TERRA, venusaur);
                formaInicial = new FormaEvolutiva("Bulbasaur", 50, 30, 1, TipoPokemon.TERRA, ivysaur);
                break;

            default:
                System.out.println("Ops, opção inválida! Eu escolho por você!");
                tipoEscolhido = TipoPokemon.ELETRICO;
                nomePokemon = "Pikachu";
                FormaEvolutiva r = new FormaEvolutiva("Raichu", 120, 70, 30, TipoPokemon.ELETRICO, null);
                formaInicial = new FormaEvolutiva("Pikachu", 50, 30, 1, TipoPokemon.ELETRICO, r);
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
        System.out.println("Ataque inicial: " + this.pokemon.getFormaAtual().getAtaqueBase()); // Teste para ver se pegou certo
        System.out.println("Defesa inicial: " + this.pokemon.getFormaAtual().getDefesaBase());
        System.out.println("A jornada começa agora...");
    }
}