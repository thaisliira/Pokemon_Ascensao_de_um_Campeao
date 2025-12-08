package Pokegotchi.Pokemons;

import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;

public abstract class Pokemon {

    protected TipoPokemon tipo;
    protected String nome;
    protected int level;
    protected int experiencia;
    protected int hpAtual;
    protected int hpMax;
    protected int nivelFome; // 100 = Cheio, 0 = Morto
    protected int nivelEnergia;
    protected int ataque;
    protected int ataqueEspecial;
    protected int defesa;
    protected int defesaEspecial;
    protected Status status;

    public Pokemon(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int nivelFome, int nivelEnergia, int ataque, int ataqueEspecial, int defesa, int defesaEspecial, Status status) {
        this.tipo = tipo;
        this.nome = nome;
        this.level = level;
        this.experiencia = experiencia;
        this.hpAtual = hpAtual;
        this.hpMax = hpMax;
        this.nivelFome = nivelFome;
        this.nivelEnergia = nivelEnergia;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defesa = defesa;
        this.defesaEspecial = defesaEspecial;
        this.status = status;
    }

    public TipoPokemon getTipo() {
        return tipo;
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

    public int getNivelFome() {
        return nivelFome;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getDefesaEspecial() {
        return defesaEspecial;
    }

    public Status getStatus() {
        return status;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setHpAtual(int hpAtual) {
        this.hpAtual = hpAtual;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public void setNivelFome(int nivelFome) {
        this.nivelFome = nivelFome;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
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

    public void verificarEstado() {

        if (this.nivelFome >= 50) {
            this.nivelFome = 50; // Trava no máximo
            this.status = Status.MORTO;
            System.out.println("☠️ " + this.nome + " não resistiu e morreu de FOME.");
            return;
        }

        if (this.nivelEnergia >= 50) {
        this.nivelEnergia = 50;
        this.status = Status.MORTO;
        System.out.println("☠️ " + this.nome + " não resistiu e morreu de EXAUSTÃO.");
        return;
        }

        if (this.nivelFome >= 40) {
            this.status = Status.DESMAIADO;
            System.out.println("⚠️ " + this.nome + " desmaiou de fome! Tadinho...");
        }
        else if (this.nivelFome >= 30) {
            System.out.println("🛑 Barriga roncando! " + this.nome + " precisa comer.");
        }

        if (this.nivelEnergia >= 40) {
            if (this.status != Status.DESMAIADO) {
                this.status = Status.DESMAIADO;
                System.out.println("💤 " + this.nome + " caiu no sono forçado!");
            }
        }
    }

    public void comer() {
        if (this.status == Status.MORTO) {
            System.out.println("Não adianta... ele se foi.");
            return;
        }

        int alimentacao = 30;
        this.nivelFome -= alimentacao;

        if (this.nivelFome < 0) {
            this.nivelFome = 0;
        }

        System.out.println("Nom nom nom! 🍎 Nível de Fome: " + this.nivelFome + "/50");

        if (this.status == Status.DESMAIADO && this.nivelFome < 40 && this.nivelEnergia < 40) {
            this.status = Status.NORMAL;
            System.out.println("✨ " + this.nome + " acordou!");
        }
    }

    public void dormir() {
        if (this.status == Status.MORTO) {
            System.out.println("Não adianta... ele se foi.");
            return;
        }

        int descanso = 30;
        this.nivelFome -= descanso;

        if (this.nivelEnergia < 0) {
            this.nivelEnergia = 0;
        }

        System.out.println("Ahhhhhh (bocejando)! ⏰ Nível de Energia: " + this.nivelEnergia + "/50");

        if (this.status == Status.DESMAIADO && this.nivelFome < 40 && this.nivelEnergia < 40) {
            this.status = Status.FELIZ;
            System.out.println("✨ " + this.nome + " acordou!");
        }
    }

    public abstract boolean atacar(Pokemon inimigo);

    public void receberDano(int dano) {
        this.hpAtual -= dano;
        if (this.hpAtual < 0) {
            this.hpAtual = 0;
        }
        System.out.println(this.nome + " perdeu " + dano + " HP! (Vida Restante: " + this.hpAtual + "/" + this.hpMax + ")");
    }
}