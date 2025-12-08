package Pokegotchi.Pokemons;

import Pokegotchi.*;
import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoPokemon;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PokemonEscolhido extends Pokemon {

    private FormaEvolutiva formaAtual;
    private int moedas;
    private ArrayList<Golpes> listaDeGolpes;
    private ArrayList<Item> listaDeItens;

    public PokemonEscolhido(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, int nivelFome, int nivelEnergia, Status status, FormaEvolutiva formaAtual, int moedas) {

        super(
                tipo,
                nome,
                level,
                experiencia,
                hpAtual,
                hpMax,
                nivelFome,
                nivelEnergia,
                formaAtual.getAtaqueBase(),
                formaAtual.getAtaqueEspecial(),
                formaAtual.getDefesaBase(),
                formaAtual.getDefesaEspecial(),
                status
        );

        this.formaAtual = formaAtual;
        this.moedas = moedas;
        this.listaDeGolpes = new ArrayList<>();
        this.listaDeItens = new ArrayList<>();
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public FormaEvolutiva getFormaAtual() {

        return formaAtual;
    }

    public void exibirDetalhesPoke() {
        System.out.println("\n--- " + this.nome.toUpperCase() + " (Lvl " + this.level + ") ---");
        System.out.println("HP: " + this.hpAtual + "/" + this.hpMax);
        System.out.println("Fome: " + this.nivelFome + "% | Energia: " + this.nivelEnergia + "%");
        System.out.println("Atk: " + this.ataque + " | Def: " + this.defesa);
        System.out.println("Status: " + this.status);
    }

    @Override
    public boolean atacar(Pokemon inimigo) {
        Scanner jogador = new Scanner(System.in);
        boolean roundEncerrado = false;

        while (!roundEncerrado) {
            System.out.println("\n--- SEU ROUND (" + this.nome + ") ---");
            System.out.println("1. Ataque Físico");
            System.out.println("2. Ataque Especial");
            System.out.println("3. Inventário");
            System.out.print("Escolha: ");

            int escolha = 0;
            if(jogador.hasNextInt()) {
                escolha = jogador.nextInt();
                jogador.nextLine();
            }

            int dano = 0;

            switch (escolha) {
                case 1:
                    dano = this.ataque - inimigo.getDefesa();

                    if (dano <= 0) dano = 1;

                    System.out.println("👊 " + this.nome + " usou um ataque físico!");
                    System.out.println("💥 Causou " + dano + " de dano!");

                    inimigo.receberDano(dano); // TODO aqui subtraio o hp do inimigo
                    roundEncerrado = true;
                    break;

                case 2:
                    dano = this.ataqueEspecial - inimigo.getDefesaEspecial();

                    if (dano <= 0) dano = 1;

                    System.out.println("⚡ " + this.nome + " usou um Ataque Especial!");
                    System.out.println("💥 Causou " + dano + " de dano!");

                    inimigo.receberDano(dano);
                    roundEncerrado = true;
                    break;

                case 3:
                    listarItens();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        return inimigo.getHpAtual() <= 0;
    }

    @Override
    public void receberDano(int dano) {
        super.receberDano(dano);

        if (this.hpAtual <= 0) {
            System.out.println("Pokemon abatido, você perdeu! Tente salvar seu pokemon!");
        } else {
            System.out.println("Você sobreviveu a esse round mas não baixe a guarda!");
            exibirDetalhesPoke();
        }
    }

    public void ganharXP(int ganhoDeXP) throws FileNotFoundException {
        this.experiencia += ganhoDeXP;
        System.out.println("✨ " + this.nome + " ganhou " + ganhoDeXP + " experiência!");

        while (this.experiencia >= 50) {
            this.experiencia -= 50;
            subirDeNivel();
        }
    }

    private void subirDeNivel() throws FileNotFoundException {
        this.level++;
        System.out.println("🎉 LEVEL UP! " + this.nome + " subiu para o nível " + this.level + "!");

        if (formaAtual.getProximaForma() != null && this.level >= formaAtual.getProximaForma().getLevelNecessario()) {
            evoluir();
        }
    }

    private void evoluir() throws FileNotFoundException {
        FormaEvolutiva novaForma = formaAtual.getProximaForma();

        System.out.println("\n------------------------------------------------");
        System.out.println("✨ O quê? " + this.nome + " está evoluindo!");
        System.out.println("...... (luz brilhante) ......");
        System.out.println("......... (forma mudando) .........");

        this.formaAtual = novaForma;
        this.setNome(novaForma.getNome());

        this.setAtaque(novaForma.getAtaqueBase());
        this.setAtaqueEspecial(novaForma.getAtaqueEspecial());
        this.setDefesa(novaForma.getDefesaBase());
        this.setDefesaEspecial(novaForma.getDefesaEspecial());

        System.out.println("\n🌟 PARABÉNS! Seu Pokémon evoluiu para " + this.nome + "!");
        System.out.println("Seus atributos aumentaram drasticamente!");
        System.out.println("------------------------------------------------\n");

        // 4. Gerar Arquivo de Texto com a Imagem
        imprimirArtePokemon();
    }

    public void imprimirArtePokemon() throws FileNotFoundException {
        String nomeArquivo = "Artes/" + this.nome.toLowerCase() + ".txt";
        System.out.println("\n");
        FileTools.printFile(nomeArquivo);
        System.out.println("\n");
    }

    public void listarItens() {
        if (listaDeItens.isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("\n=== SEU INVENTÁRIO ===");
            for (int i = 0; i < listaDeItens.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeItens.get(i).getNome());
            }
        }
    }
}