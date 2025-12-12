package Pokegotchi.Pokemons;

import Pokegotchi.*;
import Pokegotchi.Enum.Status;
import Pokegotchi.Enum.TipoItem;
import Pokegotchi.Enum.TipoPokemon;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PokemonEscolhido extends Pokemon {

    private FormaEvolutiva formaAtual;
    private int moedas;
    private ArrayList<Item> Inventario;

    public PokemonEscolhido(TipoPokemon tipo, String nome, int level, int experiencia, int hpAtual, int hpMax, Status status, FormaEvolutiva formaAtual, int moedas) {
        super(tipo,nome,level,experiencia,hpAtual,hpMax,formaAtual.getAtaqueBase(),formaAtual.getAtaqueEspecial(),formaAtual.getDefesaBase(),formaAtual.getDefesaEspecial(), status);

        this.formaAtual = formaAtual;
        this.moedas = moedas;
        this.Inventario = new ArrayList<>();
    }

    public int getMoedas() {
        return moedas;
    }

    public FormaEvolutiva getFormaAtual() {
        return formaAtual;
    }

    public void exibirDetalhesPoke() {
        System.out.println("\n--- " + this.nome.toUpperCase() + " (Lvl " + this.level + ") ---");
        System.out.println("HP: " + this.hpAtual + "/" + this.hpMax);
        System.out.println("Atk: " + this.ataque + " | Def: " + this.defesa);
        System.out.println("Status: " + this.status);
    }

    @Override
    public boolean atacar(Pokemon inimigo) {
        Scanner jogador = new Scanner(System.in);
        boolean roundEncerrado = false;

        while (!roundEncerrado) {
            System.out.println("\n------ ROUND (" + this.nome + ") ------");
            System.out.println("1. Ataque Físico");
            System.out.println("2. Ataque Especial");
            System.out.println("3. Inventário");
            System.out.println("4. Exibir Status do meu Pokemon");
            System.out.print("Escolha: ");

            int escolha = 0;

            if(jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }

            int dano = 0;

            switch (escolha) {
                case 1:
                    dano = this.ataque - inimigo.getDefesa();

                    if (dano <= 0) dano = 1;

                    System.out.println("👊 " + this.nome + " usou um ataque físico!");
                    System.out.println("💥 Causou " + dano + " de dano!");

                    inimigo.receberDano(dano);
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
                case 4:
                    exibirDetalhesPoke();
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
            this.status = Status.MORTO;
        } else {
            System.out.println("Você sobreviveu a esse round mas não baixe a guarda!");
            this.status = Status.MACHUCADO;
        }
    }

    public boolean ganharXP(int ganhoDeXP) throws FileNotFoundException {
        this.experiencia += ganhoDeXP;
        System.out.println("✨ " + this.nome + " ganhou " + ganhoDeXP + " experiência!");

        boolean prontoParaTorneio = false;

        while (this.experiencia >= 50) {
            this.experiencia -= 50;

            boolean atingiuNivel10 = subirDeNivel();
            if (atingiuNivel10) {
                prontoParaTorneio = true;
            }
        }return prontoParaTorneio;
    }

    public boolean subirDeNivel() throws FileNotFoundException {
        this.level++;
        System.out.println("🎉 LEVEL UP! " + this.nome + " subiu para o nível " + this.level + "!");

        if (formaAtual.getProximaForma() != null && this.level >= formaAtual.getProximaForma().getLevelNecessario()) {
            evoluir();
        }
        if (this.level == 8) {
            System.out.println("Seu Pokemon está quase pronto para participar do Torneio!");
        }

        if (this.level >= 10) {
            System.out.println("Seu pokemon está pronto para participar do torneio! Vamos nessa?");
            return true;
        }
        return false;
    }

    public void evoluir() throws FileNotFoundException {
        FormaEvolutiva novaForma = formaAtual.getProximaForma();

        System.out.println("\n------------------------------------------------");
        System.out.println("✨ O quê? O que está acontecendo? " + this.nome + " está evoluindo!");
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
        imprimirArtePokemon();

    }

    public void imprimirArtePokemon() throws FileNotFoundException {
        String nomeArquivo = "Artes/" + this.nome.toLowerCase() + ".txt";
        System.out.println("\n");
        FileTools.printFile(nomeArquivo);
        System.out.println("\n");
    }

    public void listarItens() {
        if (Inventario.isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("\n=== SEU INVENTÁRIO ===");
            for (int i = 0; i < Inventario.size(); i++) {
                System.out.println((i + 1) + ". " + Inventario.get(i).getNome());
            }
        }
    }

    public void adcItemInventario(Item item) {
        Inventario.add(item);
        System.out.println(item.getNome() + " foi adicionado à mochila!");
    }

    public void adicionarMoedas(int quantidade) {
        this.moedas += quantidade;
        System.out.println("💰 Ganhou " + quantidade + " moedas! Saldo atual: " + this.moedas);
    }

    public void comprarItem(Item itemComprado) {

        if(this.moedas > itemComprado.getPreco()) {
            this.moedas -= itemComprado.getPreco();
            System.out.println("Você comprou 1un do item " + itemComprado.getNome());
            this.Inventario.add(itemComprado);
            System.out.println("Saldo restante: " + this.moedas);
        } else {
            System.out.println("Você não tem moedas suficientes para realizar a compra");
        }
    }

    public void usarItem(Item itemUsado) throws FileNotFoundException {

        if (!this.Inventario.contains(itemUsado)) {
            System.out.println("Ops, você não possui esse item :(");
            return;
        }

        if (itemUsado.getItem() == TipoItem.CURA) {

            int valorCura = itemUsado.getEfeito();

            if (this.hpAtual + valorCura > this.hpMax) {

                int curaReal = this.hpMax - this.hpAtual;
                this.hpAtual = this.hpMax;
                System.out.println("💖 " + this.nome + " recuperou " + curaReal + " HP (Vida Cheia!)");
            } else {
                this.hpAtual += valorCura;
                System.out.println("💖 " + this.nome + " recuperou " + valorCura + " HP!");
            }

        } else if (itemUsado.getItem() == TipoItem.ATAQUE) {
                this.ataque += itemUsado.getEfeito();
                System.out.println("⚔️ Ataque aumentado em " + itemUsado.getEfeito() + "!");

        } else if (itemUsado.getItem() == TipoItem.DEFESA) {
                this.defesa += itemUsado.getEfeito();
                System.out.println("🛡️ Defesa aumentada em " + itemUsado.getEfeito() + "!");

        } else if (itemUsado.getItem() == TipoItem.NIVEL) {
            subirDeNivel();

        } else {
            System.out.println("Item desconhecido ou sem efeito.");
        }

        this.Inventario.remove(itemUsado);
    }
}
