package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;

public class NPCPokemon extends Pokemon {

    public NPCPokemon(TipoPokemon tipo, String nome, int level, int hpMax, int ataque, int ataqueEspecial, int defesa, int defesaEspecial) {
        super( tipo, nome, level, 0, hpMax, hpMax, ataque, ataqueEspecial, defesa, defesaEspecial, Status.NORMAL);
    }

    @Override
    public boolean atacar(Pokemon inimigo) {
        return false;
    }
}