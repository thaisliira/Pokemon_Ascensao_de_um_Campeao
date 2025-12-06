package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;

public class Pokemon {

    private TipoPokemon tipo;
    private String nome;
    private int level;
    private int experiencia;
    private int hpAtual;
    private int hpMax;
    private int nivelFome;
    private int nivelEnergia;
    private int ataque;
    private int defesa;
    private Status status;

    public Pokemon(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int nivelFome, int nivelEnergia, int ataque, int defesa, Status status) {
        this.tipo = tipo;
        this.nome = nome;
        this.level = level;
        this.experiencia = experiencia;
        this.hpAtual = hpAtual;
        this.hpMax = hpMax;
        this.nivelFome = nivelFome;
        this.nivelEnergia = nivelEnergia;
        this.ataque = ataque;
        this.defesa = defesa;
        this.status = status;
    }

}