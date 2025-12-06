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

    // CONSTRUTOR CORRIGIDO
    // Agora passa os atributos Físicos E Especiais para o super
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
                formaAtual.getAtaqueBase(),          // 9. Ataque Físico (Vem da Forma)
                formaAtual.getAtaqueEspecial(),  // 10. Ataque Especial (Vem da Forma)
                formaAtual.getDefesaBase(),          // 11. Defesa Física (Vem da Forma)
                formaAtual.getDefesaEspecial(),  // 12. Defesa Especial (Vem da Forma)
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
}