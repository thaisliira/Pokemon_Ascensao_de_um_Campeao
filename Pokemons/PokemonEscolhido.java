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

    /**
     * Função que exibe o status do meu pokemon: vida, ataque, defesa...
     */
    public void exibirDetalhesPoke() {
        System.out.println("\n--- " + this.nome.toUpperCase() + " (Lvl " + this.level + ") ---");
        System.out.println("Experiência(XP): " + this.experiencia);
        System.out.println("Vida(HP): " + this.hpAtual + "/" + this.hpMax);
        System.out.println("Atk: " + this.ataque + " | Def: " + this.defesa);
        System.out.println("Atk Sp: " + this.ataqueEspecial + " | Def Sp: " + this.defesaEspecial);
        System.out.println("Status: " + this.status);
    }

    @Override
    public boolean atacar(Pokemon inimigo) throws FileNotFoundException {
        Scanner jogador = new Scanner(System.in);
        boolean roundEncerrado = false;
        boolean inimigoDerrotado = false;

        while (!roundEncerrado) {
            System.out.println("\n------ SEU ROUND (" + this.nome + ") ------");
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
                    // condição se a defesa for maior que o ataque
                    if (dano <= 0) dano = 2;

                    System.out.println("\n👊 " + this.nome + " usou um ataque físico!");
                    System.out.println("💥 Causou " + dano + " de dano!");
                    inimigo.receberDano(dano);
                    roundEncerrado = true;
                    break;
                case 2:
                    dano = this.ataqueEspecial - inimigo.getDefesaEspecial();
                    if (dano <= 0) dano = 2;
                    System.out.println("\n⚡ " + this.nome + " usou um Ataque Especial!");
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
                    break;
            }
        }
        // retorno para saber se o inimigo foi derrotado
        if (inimigo.getHpAtual() <= 0) {
            inimigoDerrotado = true;
        }
        return inimigoDerrotado;
    }

    /**
     * Funçao que herda do elemento pai, mas imprime uma mensagem específica
     * @param dano subtrai do valor do HP
     */
    @Override
    public void receberDano(int dano) {
        // chama a função receber dano do super e aplica
        super.receberDano(dano);
        if (this.hpAtual <= 0) {
            System.out.println("☠️☠️☠️ Game over ☠️☠️☠️");
            System.out.println("Seu Pokémon não resistiu e morreu...⚰️");
            System.exit(0);
        } else if (this.hpAtual != 100){
            System.out.println("Você sobreviveu a esse round mas não baixe a guarda!");
            this.status = Status.MACHUCADO;
        }
    }

    /**
     * Função que adiciona ganho de experiência ao Pokemon após cada batalha
     * @param ganhoDeXP após batalha
     * @return se o pokemon ganhou experiencia suficiente e atingiu o nivel 10, está pronto para o torneio
     * @throws FileNotFoundException
     */
    public void ganharXP(int ganhoDeXP) throws FileNotFoundException {
        this.experiencia += ganhoDeXP;
        System.out.println("\n✨ " + this.nome + " ganhou " + ganhoDeXP + " de experiência!");

        while (this.experiencia >= 50) {
            this.experiencia -= 50;
            subirDeNivel();
        }
    }

    /**
     * Função que permite o pokemon subir de nível conforme o XP e dependendo do nivel pode ou não evoluir
     * @throws FileNotFoundException
     */
    public void subirDeNivel() throws FileNotFoundException {
        this.level++;
        System.out.println("🎉 LEVEL UP! " + this.nome + " subiu para o nível " + this.level + "!");

        if (formaAtual.getProximaForma() != null && this.level >= formaAtual.getProximaForma().getLevelNecessario()) {
            evoluir();
        }
        if (this.level == 8) {
            System.out.println("\nSeu Pokemon está quase pronto para participar do Torneio!");
        }
    }

    /**
     * Função que permiete evolução do pokemon e imprime a arte correspondente
     * @throws FileNotFoundException
     */
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

    /**
     * Imprime arquivo .txt do pokemon
     * @throws FileNotFoundException
     */
    public void imprimirArtePokemon() throws FileNotFoundException {
        String nomeArquivo = "Artes/" + this.nome.toLowerCase() + ".txt";
        System.out.println("\n");
        FileTools.printFile(nomeArquivo);
        System.out.println("\n");
    }

    /**
     * Lista os itens presentes no inventário do jogador
     * @throws FileNotFoundException
     */
    public void listarItens() throws FileNotFoundException {
        while (true) {
            if (this.Inventario.isEmpty()) {
                System.out.println("🎒 Sua mochila está vazia. Passe na loja!");
                System.out.println("\uD83D\uDCB0 Quantidade de moedas: " + this.moedas);
                return;
            }

            System.out.println("\n======== SEU INVENTÁRIO ========");
            System.out.println("Quantidade de moedas: " + this.moedas);
            int i = 1;
            for (Item item : this.Inventario) {
                System.out.println(i + ". " + item.getNome() + item.getDescEfeito());
                i++;
            }
            System.out.println("0. Voltar"); // porque não sei quantos itens o usuário vai ter
            System.out.print("Escolha o número do item para usar (ou 0 para voltar): ");

            Scanner jogador = new Scanner(System.in);
            int escolha = -1;

            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }
            if (escolha == 0) {
                return;
            }  else if (escolha > 0 && escolha <= this.Inventario.size()) {
                Item itemEscolhido = this.Inventario.get(escolha - 1); // porque no ArrayList o item 1 está no índice 0
                usarItem(itemEscolhido);
            } else {
                System.out.println("⚠️ Escolha inválida!");
            }
        }
    }

    public void inventarioTorneio() throws FileNotFoundException {
        while (true) {
            if (this.Inventario.isEmpty()) {
                System.out.println("🎒 Sua mochila está vazia. Passe na loja!");
                System.out.println("\uD83D\uDCB0 Quantidade de moedas: " + this.moedas);
                return;
            }

            System.out.println("\n======== SEU INVENTÁRIO ========");
            System.out.println("Quantidade de moedas: " + this.moedas);
            int i = 1;
            for (Item item : this.Inventario) {
                System.out.println(i + ". " + item.getNome() + item.getDescEfeito());
                i++;
            }
            System.out.println("0. Voltar"); // porque não sei quantos itens o usuário vai ter
            System.out.print("Escolha o número do item para usar (ou 0 para voltar): ");

            Scanner jogador = new Scanner(System.in);
            int escolha = -1;

            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }
            if (escolha == 0) {
                return;
            }  else if (escolha > 0 && escolha <= this.Inventario.size()) {
                Item itemEscolhido = this.Inventario.get(escolha - 1); // porque no ArrayList o item 1 está no índice 0
                usarItem(itemEscolhido);
            } else {
                System.out.println("⚠️ Escolha inválida!");
            }
        }
    }

    /**
     * Função para adicionar item ao inventário
     * @param item comprado na loja ou item encontrado no mapa
     */
    public void adcItemInventario(Item item) {
        Inventario.add(item);
        System.out.println(item.getNome() + " foi adicionado à mochila!");
    }

    /**
     * Função para adicionar moedas após o treinamento
     * @param quantidade
     */
    public void adicionarMoedas(int quantidade) {
        this.moedas += quantidade;
        System.out.println("💰 Ganhou " + quantidade + " moedas! Saldo atual: " + this.moedas);
    }

    /**
     * Função para verificar se tem moedas suficientes e comprar itens na loja
     * @param itemComprado na loja
     */
    public void comprarItem(Item itemComprado) {
        if(this.moedas > itemComprado.getPreco()) {
            this.moedas -= itemComprado.getPreco();
            System.out.println("Você comprou 1un do item " + itemComprado.getNome());
            this.Inventario.add(itemComprado);
            System.out.println("Saldo restante: " + this.moedas);
        } else {
            System.out.println("Você não tem moedas suficientes para realizar a compra! Ganhe batalhas treinando e receba moedas!");
        }
    }

    /**
     * Função que permite utilizar um item e remove-lo do inventário após o uso
     * @param itemUsado disponível no inventário
     * @throws FileNotFoundException
     */
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
                this.status = Status.FELIZ;
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
