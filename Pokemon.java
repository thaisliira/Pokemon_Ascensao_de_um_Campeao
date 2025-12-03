package Pokegotchi.Pokemons;

import Pokegotchi.Enum.TipoPokemon;

public class Pokemon {

    private TipoPokemon tipo;
    private int level;
    private int experiencia;
    private int hpAtual;
    private int hpMax;

    public Pokemon(TipoPokemon tipo, int level, int experiencia, int hpAtual, int hpMax) {
        this.tipo = tipo;
        this.level = level;
        this.experiencia = experiencia;
        this.hpAtual = hpAtual;
        this.hpMax = hpMax;
    }

}