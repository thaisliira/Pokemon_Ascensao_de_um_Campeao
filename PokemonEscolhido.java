package Pokegotchi.Pokemons;

import Pokegotchi.Inventario;
import Pokegotchi.TiposGolpes;

import java.util.ArrayList;

public class PokemonEscolhido extends Pokemon {

    private boolean evolucao;
    private Double moedas;
    private ArrayList<TiposGolpes> listaDeGolpes;
    private ArrayList<Inventario> listaDeItens;

    public boolean isEvolucao() {
        return evolucao;
    }

    public double getMoedas() {
        return moedas;
    }
}
