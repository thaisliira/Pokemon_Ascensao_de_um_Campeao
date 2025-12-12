package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;

import java.io.FileNotFoundException;

public abstract class Pokemon {

    protected TipoPokemon tipo;
    protected String nome;
    protected int level;
    protected int experiencia;
    protected int hpAtual;
    protected int hpMax;
    protected int ataque;
    protected int ataqueEspecial;
    protected int defesa;
    protected int defesaEspecial;
    protected Status status;

    public Pokemon(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int ataque, int ataqueEspecial, int defesa, int defesaEspecial, Status status) {
        this.tipo = tipo;
        this.nome = nome;
        this.level = level;
        this.experiencia = experiencia;
        this.hpAtual = hpAtual;
        this.hpMax = hpMax;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defesa = defesa;
        this.defesaEspecial = defesaEspecial;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public int getLevel() {
        return level;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getHpAtual() {
        return hpAtual;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getDefesaEspecial() {
        return defesaEspecial;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setDefesaEspecial(int defesaEspecial) {
        this.defesaEspecial = defesaEspecial;
    }

    public abstract boolean atacar(Pokemon inimigo) throws FileNotFoundException;

    public void receberDano(int dano) {
        this.hpAtual -= dano;
        if (this.hpAtual < 0) {
            this.hpAtual = 0;
        }
        System.out.println(this.nome + " perdeu " + dano + " HP! (Vida Restante: " + this.hpAtual + "/" + this.hpMax + ")");
    }

}