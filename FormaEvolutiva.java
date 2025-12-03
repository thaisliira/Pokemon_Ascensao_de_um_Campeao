package Pokegotchi;

import Pokegotchi.Enum.TipoPokemon;

public class FormaEvolutiva {

    private String nome;
    private int ataqueBase;
    private int defesaBase;
    private int levelNecessario;
    TipoPokemon tipo;
    FormaEvolutiva proximaForma;

    public FormaEvolutiva(String nome, int ataqueBase, int defesaBase, int levelNecessario, TipoPokemon tipo, FormaEvolutiva proximaForma) {
        this.nome = nome;
        this.ataqueBase = ataqueBase;
        this.defesaBase = defesaBase;
        this.levelNecessario = levelNecessario;
        this.tipo = tipo;
        this.proximaForma = proximaForma;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public int getLevelNecessario() {
        return levelNecessario;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public FormaEvolutiva getProximaForma() {
        return proximaForma;
    }
}
