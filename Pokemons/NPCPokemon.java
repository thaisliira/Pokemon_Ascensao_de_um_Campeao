package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;
import Pokegotchi.Pokemons.Pokemon;

public class NPCPokemon extends Pokemon {

    public NPCPokemon(TipoPokemon tipo, String nome, int level, int hpMax, int ataque, int ataqueEspecial, int defesa, int defesaEspecial) {

        // Chama o PAI (Pokemon) preenchendo automaticamente o que falta:
        super(
                tipo,           // 1. Tipo
                nome,           // 2. Nome
                level,          // 3. Level
                0,              // 4. Experiência (NPC começa com 0)
                hpMax,          // 5. HP Atual
                hpMax,          // 6. HP Máximo
                0,              // 7. Fome (NPC não tem fome)
                100,            // 8. Energia (NPC não cansa)
                ataque,         // 9. Ataque Físico
                ataqueEspecial, // 10. Ataque Especial
                defesa,         // 11. Defesa Física
                defesaEspecial, // 12. Defesa Especial
                Status.NORMAL   // 13. Status
        );
    }

    @Override
    public boolean atacar(Pokemon inimigo) {
        return false;
    }
}