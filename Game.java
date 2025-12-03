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

        int opcao = jogador.nextInt();
        jogador.nextLine();

        if (opcao == 1) {
            criarSave();
        } else {
            System.exit(0);
        }
    }

    private void criarSave() {
        System.out.println("\n--------------------------------");
        System.out.println("Olá, jovem treinador!");
        System.out.print("Primeiro, diga-me, qual é o seu nome? ");
        this.nomeJogador = jogador.nextLine();

        System.out.println("\nPrazer em te conhecer, mestre " + this.nomeJogador+ "!");

        // Dicas visuais
        System.out.println("\n---");

        System.out.println("\nEscolha seu parceiro:");
        System.out.println("1. " + "Pokebola 1");
        System.out.println("2. " + "Pokebola 2");
        System.out.println("3. " +  "Pokebola 3");
        System.out.print("Sua escolha (1-3): ");

        int escolha = jogador.nextInt();
        inicializarPokemon(escolha);
    }

    // --- CORREÇÃO AQUI ---
    private void inicializarPokemon(int escolha) {
        TipoPokemon tipoEscolhido = null;
        String nomePokemon = "";
        FormaEvolutiva formaInicial = null; // Variável para segurar a forma correta

        switch (escolha) {
            case 1: // Água
                tipoEscolhido = TipoPokemon.AGUA;
                nomePokemon = "Squirtle";

                // Criando a cadeia: Blastoise -> Wartortle -> Squirtle
                FormaEvolutiva blastoise = new FormaEvolutiva("Blastoise", 100, 100, 36, TipoPokemon.AGUA, null);
                FormaEvolutiva wartortle = new FormaEvolutiva("Wartortle", 60, 60, 16, TipoPokemon.AGUA, blastoise);
                formaInicial = new FormaEvolutiva("Squirtle", 30, 30, 1, TipoPokemon.AGUA, wartortle);
                break;

            case 2: // Fogo
                tipoEscolhido = TipoPokemon.FOGO;
                nomePokemon = "Charmander";

                // Criando a cadeia: Charizard -> Charmeleon -> Charmander
                FormaEvolutiva charizard = new FormaEvolutiva("Charizard", 110, 80, 36, TipoPokemon.FOGO, null);
                FormaEvolutiva charmeleon = new FormaEvolutiva("Charmeleon", 70, 50, 16, TipoPokemon.FOGO, charizard);
                formaInicial = new FormaEvolutiva("Charmander", 40, 20, 1, TipoPokemon.FOGO, charmeleon);
                break;

            case 3: // Terra
                tipoEscolhido = TipoPokemon.TERRA;
                nomePokemon = "Bulbasaur";

                FormaEvolutiva raichu = new FormaEvolutiva("Raichu", 120, 70, 30, TipoPokemon.ELETRICO, null);
                formaInicial = new FormaEvolutiva("Pikachu", 50, 30, 1, TipoPokemon.ELETRICO, raichu);
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
                1,              // Level
                0,              // XP
                20,             // HP Atual
                20,             // HP Max
                0,              // Fome
                100,            // Energia
                10,             // Ataque
                5,              // Defesa
                Status.FELIZ,
                formaInicial,   // <--- Aqui entra o objeto criado no switch
                100             // Moedas
        );

        System.out.println("\n" + "PARABÉNS!");
        System.out.println("Você escolheu o " + nomePokemon + "!");
        System.out.println("A jornada começa agora...");
    }

}