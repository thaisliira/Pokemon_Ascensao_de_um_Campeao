package Pokemon_Ascensao.Pokemons;

import Pokemon_Ascensao.Enum.Status;
import Pokemon_Ascensao.Enum.TipoPokemon;

/**
 * Classe que adiciona atributos ao NPC pokémon
 */
public class NPCPokemon extends Pokemon {

    public NPCPokemon(TipoPokemon tipo, String nome, int level, int hpMax, int ataque, int ataqueEspecial, int defesa, int defesaEspecial) {
        super(tipo, nome, level, 0, hpMax, hpMax, ataque, ataqueEspecial, defesa, defesaEspecial, Status.NORMAL);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    /**
     *
     * @param inimigo nesse caso é o pokémon do jogador
     * @return retorno após o ataque
     */
    @Override
    public boolean atacar(Pokemon inimigo) {
        return false;
    }
}