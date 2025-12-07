package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;
import Pokegotchi.FormaEvolutiva;
import Pokegotchi.Golpes;
import Pokegotchi.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class PokemonEscolhido extends Pokemon {

    private FormaEvolutiva formaAtual;
    private int moedas;
    private ArrayList<Golpes> listaDeGolpes;
    private ArrayList<Item> listaDeItens;

    public PokemonEscolhido(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int nivelFome, int nivelEnergia, Status status, FormaEvolutiva formaAtual, int moedas) {

        super(
                tipo,
                nome,
                level,
                experiencia,
                hpAtual,
                hpMax,
                nivelFome,
                nivelEnergia,
                formaAtual.getAtaqueBase(),
                formaAtual.getAtaqueEspecial(),
                formaAtual.getDefesaBase(),
                formaAtual.getDefesaEspecial(),
                status
        );

        this.formaAtual = formaAtual;
        this.moedas = moedas;
        this.listaDeGolpes = new ArrayList<>();
        this.listaDeItens = new ArrayList<>();
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public FormaEvolutiva getFormaAtual() {

        return formaAtual;
    }

    public void exibirDetalhesPoke() {
        System.out.println("\n--- " + this.nome.toUpperCase() + " (Lvl " + this.level + ") ---");
        System.out.println("HP: " + this.hpAtual + "/" + this.hpMax);
        System.out.println("Fome: " + this.nivelFome + "% | Energia: " + this.nivelEnergia + "%");
        System.out.println("Atk: " + this.ataque + " | Def: " + this.defesa);
        System.out.println("Status: " + this.status);
    }

    @Override
    public boolean atacar(Pokemon inimigo) {
        Scanner jogador = new Scanner(System.in);
        boolean roundEncerrado = false;

        while (!roundEncerrado) {
            System.out.println("\n--- SEU ROUND (" + this.nome + ") ---");
            System.out.println("1. Ataque Físico");
            System.out.println("2. Ataque Especial");
            System.out.println("3. Inventário");
            System.out.print("Escolha: ");

            int escolha = 0;
            if(jogador.hasNextInt()) {
                escolha = jogador.nextInt();
                jogador.nextLine();
            }

            int dano = 0;

            switch (escolha) {
                case 1:
                    dano = this.ataque - inimigo.getDefesa();

                    if (dano <= 0) dano = 1;

                    System.out.println("👊 " + this.nome + " usou um ataque físico!");
                    System.out.println("💥 Causou " + dano + " de dano!");

                    inimigo.receberDano(dano); // TODO aqui subtraio o hp do inimigo
                    roundEncerrado = true;
                    break;

                case 2:
                    dano = this.ataqueEspecial - inimigo.getDefesaEspecial();

                    if (dano <= 0) dano = 1;

                    System.out.println("⚡ " + this.nome + " usou um Ataque Especial!");
                    System.out.println("💥 Causou " + dano + " de dano!");

                    inimigo.receberDano(dano);
                    roundEncerrado = true;
                    break;

                case 3:
                    System.out.println("🎒 Mochila vazia..."); // TODO buscar inventario do jogador
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        return inimigo.getHpAtual() <= 0;
    }
}