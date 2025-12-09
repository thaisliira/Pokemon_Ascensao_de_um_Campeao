package Pokegotchi;

import Pokegotchi.Enum.TipoPokemon;

public class FormaEvolutiva {

    private String nome;
    private int ataqueBase;
    private int defesaBase;
    private int ataqueEspecial;
    private int defesaEspecial;
    private int levelNecessario;
    private TipoPokemon tipo;
    private FormaEvolutiva proximaForma;

    public FormaEvolutiva(String nome, int ataqueBase, int ataqueEspecial, int defesaBase, int defesaEspecial, int levelNecessario, TipoPokemon tipo, FormaEvolutiva proximaForma) {
        this.nome = nome;
        this.ataqueBase = ataqueBase;
        this.ataqueEspecial = ataqueEspecial;
        this.defesaBase = defesaBase;
        this.defesaEspecial = defesaEspecial;
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

    public TipoPokemon getTipo() {
        return tipo;
    }

    public FormaEvolutiva getProximaForma() {
        return proximaForma;
    }
}