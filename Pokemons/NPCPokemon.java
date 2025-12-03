package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;

public class NPCPokemon extends Pokemon {

    private int levelInicio;


    public NPCPokemon(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int nivelFome, int nivelEnergia, int ataque, int defesa, Status status) {
        super(tipo, nome, level, experiencia, hpAtual, hpMax, nivelFome, nivelEnergia, ataque, defesa, status);
    }
}