package Pokegotchi.Pokemons;

import Pokegotchi.Enum.TipoPokemon;

public class NPCPokemon extends Pokemon {

    private String nome;

    public NPCPokemon(TipoPokemon tipo, int level, int experiencia, int hpAtual, int hpMax, String nome) {
        super(tipo, level, experiencia, hpAtual, hpMax);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
