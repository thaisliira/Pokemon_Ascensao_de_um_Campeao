package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;
import Pokegotchi.FormaEvolutiva;
import Pokegotchi.Golpes;
import Pokegotchi.Item;

import java.util.ArrayList;

public class PokemonEscolhido extends Pokemon {

    private FormaEvolutiva formaAtual;
    private int moedas;
    private ArrayList<Golpes> listaDeGolpes;
    private ArrayList<Item> listaDeItens;

    // Construtor Inteligente: Pega os stats da formaInicial e passa para o Super (Pokemon)
    public PokemonEscolhido(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int nivelFome, int nivelEnergia, Status status, FormaEvolutiva formaAtual, int moedas) {

        // Note aqui: Passamos formaAtual.getAtaqueBase() para o ataque do Pokemon
        super(
                tipo,
                nome,
                level,
                experiencia,
                hpAtual,
                hpMax,
                nivelFome,
                nivelEnergia,
                formaAtual.getAtaqueBase(), // ATAQUE VEM DA FORMA
                formaAtual.getDefesaBase(), // DEFESA VEM DA FORMA
                status
        );

        this.formaAtual = formaAtual;
        this.moedas = moedas;
        this.listaDeItens = new ArrayList<Item>();
        this.listaDeGolpes = new ArrayList<Golpes>();
    }

    public int getMoedas() {
        return moedas;
    }

    public FormaEvolutiva getFormaAtual() {
        return formaAtual;
    }
}