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

    public PokemonEscolhido(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int nivelFome, int nivelEnergia, int ataque, int defesa, Status status, FormaEvolutiva formaAtual, int moedas) {
        super(tipo, nome, level, experiencia, hpAtual, hpMax, nivelFome, nivelEnergia, ataque, defesa, status);
        this.formaAtual = formaAtual;
        this.moedas = moedas;
        this.listaDeItens = new ArrayList<Item>();
        this.listaDeGolpes = new ArrayList<Golpes>();
    }
}