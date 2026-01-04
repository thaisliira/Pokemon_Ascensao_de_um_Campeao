package Pokegotchi;

import Pokegotchi.Enum.TipoPokemon;

public class FormaEvolutiva {

    private final String nome;
    private final int ataqueBase;
    private final int defesaBase;
    private final int ataqueEspecial;
    private final int defesaEspecial;
    private final int levelNecessario;
    private final FormaEvolutiva proximaForma;

    public FormaEvolutiva(String nome, int ataqueBase, int ataqueEspecial, int defesaBase, int defesaEspecial, int levelNecessario, TipoPokemon tipo, FormaEvolutiva proximaForma) {
        this.nome = nome;
        this.ataqueBase = ataqueBase;
        this.ataqueEspecial = ataqueEspecial;
        this.defesaBase = defesaBase;
        this.defesaEspecial = defesaEspecial;
        this.levelNecessario = levelNecessario;
        this.proximaForma = proximaForma;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public int getDefesaEspecial() {
        return defesaEspecial;
    }

    public int getLevelNecessario() {
        return levelNecessario;
    }

    public FormaEvolutiva getProximaForma() {
        return proximaForma;
    }
}