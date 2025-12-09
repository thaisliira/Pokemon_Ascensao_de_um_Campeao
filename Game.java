package Pokegotchi;

import Pokegotchi.Enum.Mapa;
import Pokegotchi.Pokemons.NPCPokemon;
import Pokegotchi.Pokemons.PokemonEscolhido;
import Pokegotchi.Enum.TipoPokemon;
import Pokegotchi.Enum.Status;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private String nomeJogador;
    private PokemonEscolhido pokemon;
    private ArrayList<NPCPokemon> selvagens;
    private ArrayList<NPCPokemon> pokemonTorneio;
    private Scanner jogador;

    public Game() {
        this.jogador = new Scanner(System.in);
        this.selvagens = new ArrayList<>();
        this.pokemonTorneio = new ArrayList<>();
    }

    /**
     * Função que tem o menu iniciar o jogo
     * @throws FileNotFoundException
     */
    public void iniciar() throws FileNotFoundException {
        System.out.println("BEM-VINDO AO MUNDO POKÉGOTCHI!");
        System.out.println("1. Jogar");
        System.out.println("2. Sair");
        System.out.print("Escolha uma opção: ");

        if (jogador.hasNextInt()) {
            int opcao = jogador.nextInt();
            jogador.nextLine();

            if (opcao == 1) {
                iniciarJogo();
            } else {
                System.out.println("Já vai? Que pena! Até a próxima!");
                System.exit(0);
            }
        } else {
            System.out.println("Entrada inválida. Tente outra opção.");
        }
    }

    /**
     * Função com menu de Nome do jogador e escolha do pokemon
     * @throws FileNotFoundException
     */
    private void iniciarJogo() throws FileNotFoundException {
        System.out.println("\n--------------------------------");
        System.out.println("Olá, jovem treinador!");
        System.out.print("Primeiro, me diz, qual é o seu nome? ");
        this.nomeJogador = jogador.nextLine();

        System.out.println("\nPrazer em te conhecer, " + this.nomeJogador + "!");
        System.out.println("\n---");
        System.out.println("Agora é a hora de escolher seu parceiro:");
        System.out.println("1. Pokebola (Elemento Água)");
        System.out.println("2. Pokebola (Elemento Fogo)");
        System.out.println("3. Pokebola (Elemento Terra)");
        System.out.print("Qual elemento você prefere? (1-3): ");

        int escolha = 0;
        if (jogador.hasNextInt()) {
            escolha = jogador.nextInt();
            jogador.nextLine();
        }

        iniciarPokemon(escolha);
    }

    /**
     * Funcao que determina as caracteristicas do pokemon escolhido de acordo com o tipo
     * @param escolha
     * @throws FileNotFoundException
     */
    private void iniciarPokemon(int escolha) throws FileNotFoundException {
        TipoPokemon tipoEscolhido = null;
        String nomePokemon = "";
        FormaEvolutiva formaInicial = null;

        switch (escolha) {
            case 1:
                tipoEscolhido = TipoPokemon.AGUA;
                nomePokemon = "Squirtle";

                FormaEvolutiva blastoise = new FormaEvolutiva("Blastoise", 80, 90, 70, 96, 13, TipoPokemon.AGUA, null);
                FormaEvolutiva wartortle = new FormaEvolutiva("Wartortle", 60, 90, 60,80, 6, TipoPokemon.AGUA, blastoise);
                formaInicial = new FormaEvolutiva("Squirtle", 30, 50, 30,60, 1, TipoPokemon.AGUA, wartortle);
                break;
            case 2:
                tipoEscolhido = TipoPokemon.FOGO;
                nomePokemon = "Charmander";

                FormaEvolutiva megaCharizard = new FormaEvolutiva("Mega Charizard", 120, 130, 70, 110, 13, TipoPokemon.FOGO, null);
                FormaEvolutiva charizard = new FormaEvolutiva("Charizard", 80, 110, 50, 90, 10, TipoPokemon.FOGO, megaCharizard);
                FormaEvolutiva charmeleon = new FormaEvolutiva("Charmeleon", 50, 90, 40, 70, 6, TipoPokemon.FOGO, charizard);
                formaInicial = new FormaEvolutiva("Charmander", 40, 60, 25, 50, 1, TipoPokemon.FOGO, charmeleon);
                break;
            case 3:
                tipoEscolhido = TipoPokemon.TERRA;
                nomePokemon = "Bulbasaur";

                FormaEvolutiva venusaur = new FormaEvolutiva("Venusaur", 90, 100, 60, 100, 10, TipoPokemon.TERRA, null);
                FormaEvolutiva ivysaur = new FormaEvolutiva("Ivysaur", 60, 90, 50, 90, 6, TipoPokemon.TERRA, venusaur);
                formaInicial = new FormaEvolutiva("Bulbasaur", 30, 40, 30,40, 1, TipoPokemon.TERRA,  ivysaur);
                break;
            default:
                System.out.println("Ops, opção inválida! Eu escolho por você!");
                tipoEscolhido = TipoPokemon.NORMAL;
                nomePokemon = "Ditto";
                formaInicial = new FormaEvolutiva("Ditto", 20, 25, 10, 15, 1, TipoPokemon.NORMAL, null);
                break;
        }

        this.pokemon = new PokemonEscolhido( tipoEscolhido,  nomePokemon, 1, 0, 100, 100, Status.FELIZ,  formaInicial,  100);

        System.out.println("\nPARABÉNS!");
        System.out.println("Você escolheu o " + nomePokemon + "!");
        this.pokemon.imprimirArtePokemon();
        System.out.println("HP atual: " + this.pokemon.getHpAtual());
        System.out.println("XP Atual: " + this.pokemon.getExperiencia());
        System.out.println("Ataque Básico: " + this.pokemon.getFormaAtual().getAtaqueBase());
        System.out.println("Defesa Básica: " + this.pokemon.getFormaAtual().getDefesaBase());
        System.out.println("Quantidade de moedas: " + this.pokemon.getMoedas());
        System.out.println("Sua jornada começa agora...");

        menuPrincipal();
    }

    /**
     * Função com menu principal de açoes: explorar, treinar, loja ou sair
     * @throws FileNotFoundException
     */
    private void menuPrincipal() throws FileNotFoundException {
        boolean jogando = true;
        while (jogando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("O que deseja fazer?");
            System.out.println("1. Explorar");
            System.out.println("2. Treinar");
            System.out.println("3. Loja");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");

            int escolha = 0;
            if (jogador.hasNextInt()) {
                escolha = jogador.nextInt();
            }

            switch (escolha) {
                case 1:
                    menuExplorar();
                    break;
                case 2:
                    treinar();
                    break;
                case 3:
                    visitarLoja();
                    break;
                case 4:
                    System.out.println("Até a próxima!");
                    jogando = false;
                    break;
                default:
                    System.out.println("⚠️ Opção inválida!");
            }
        }
    }

    /**
     * Funcao para visitar a loja e comprar itens
     */
    private void visitarLoja() {
        System.out.println("A loja está fechada para reforma! (Em construção...)");
    }

    /**
     * Funçao com menu de exploraçao
     * @throws FileNotFoundException
     */
    private void menuExplorar() throws FileNotFoundException {
        System.out.println("\n--- MAPA DE EXPLORAÇÃO ---");
        System.out.println("Para onde deseja viajar?");
        System.out.println("1. Floresta Viridian");
        System.out.println("2. Vulcão em Chamas");
        System.out.println("3. Lago Sombrio");
        System.out.println("4. Usina Elétrica");
        System.out.println("5. Voltar");
        System.out.print("Escolha sua rota (1-4): ");
        int escolha = 0;

        if (jogador.hasNextInt()) {
            escolha = jogador.nextInt();
            jogador.nextLine();
        }

        Mapa mapaEscolhido = null;

        switch (escolha) {
            case 1:
                mapaEscolhido = Mapa.FLORESTA;
                break;
            case 2:
                mapaEscolhido = Mapa.VULCAO;
                break;
            case 3:
                mapaEscolhido = Mapa.LAGO;
                break;
            case 4:
                mapaEscolhido = Mapa.USINA;
                break;
            case 5:
                return;
            default:
                System.out.println("⚠️ Esse local não existe no mapa!");
                return;
        }

        if (mapaEscolhido != null) {
            System.out.println("Viajando para " + mapaEscolhido.getNome());
            iniciarExploracao(mapaEscolhido);
        }
    }

    private void iniciarExploracao(Mapa mapa) throws FileNotFoundException {

        int encontrarInimigo = new java.util.Random().nextInt(100);

        if (encontrarInimigo < 60) {

            TipoPokemon tipoDoLocal = mapa.getTipoInimigo();
            int nivelInimigo = (this.pokemon.getLevel() / 2) + 1;
            String nomeInimigo = "";
            int hpBase = 0;
            int atkBase = 0;
            int defBase = 0;

            switch (tipoDoLocal) {
                case FOGO:
                    nomeInimigo = "Scorbunny";
                    hpBase = 70; atkBase = 40; defBase = 30;
                    break;
                case AGUA:
                    nomeInimigo = "Totodile";
                    hpBase = 80; atkBase = 50; defBase = 40;
                    break;
                case TERRA:
                    nomeInimigo = "Diglett";
                    hpBase = 75; atkBase = 45; defBase = 30;
                    break;
                case ELETRICO:
                    nomeInimigo = "Pichu";
                    hpBase = 85; atkBase = 55; defBase = 50;
                    break;
                default:
                    nomeInimigo = "Ditto Perdido";
                    hpBase = 50; atkBase = 30; defBase = 30;
                    break;
            }

            int ataqueFinal = atkBase + nivelInimigo;
            int defesaFinal = defBase + (nivelInimigo / 2);

            NPCPokemon inimigo = new NPCPokemon(tipoDoLocal,nomeInimigo,nivelInimigo,hpBase + (nivelInimigo * 5), ataqueFinal, ataqueFinal, defesaFinal, defesaFinal);

            System.out.println("\n⚔️ CUIDADO! Um " + inimigo.getNome() + " (Nvl " + nivelInimigo + ") apareceu!");
            System.out.println("HP: " + inimigo.getHpMax() + " | Atk: " + inimigo.getAtaque() + " | Def: " + inimigo.getDefesa());

            boolean decisaoTomada = false;
            pokemon.ganharXP(30);

            while (!decisaoTomada) {
                System.out.println("\nO que você vai fazer?");
                System.out.println("1. Batalhar!");
                System.out.println("2. Tentar Fugir");
                System.out.println("3. Verificar Status do meu Pokemon");
                System.out.print("Faça sua escolha: ");

                int decisao = 0;
                if (jogador.hasNextInt()) {
                    decisao = jogador.nextInt();
                    jogador.nextLine();
                }

                if (decisao == 1) {
                    System.out.println("Você decidiu batalhar, boa sorte!");
                    batalhar(inimigo);
                    decisaoTomada = true;
                }
                else if (decisao == 2) {
                    tentarFugir(inimigo);
                    decisaoTomada = true;
                }
                else if (decisao == 3) {
                    pokemon.exibirDetalhesPoke();
                }
                else {
                    System.out.println("Você ficou paralisado de medo... A batalha começou!");
                    batalhar(inimigo);
                    decisaoTomada = true;
                }
            }

        } else {
            System.out.println("🍃 Você caminhou pelo " + mapa.getNome() + " e estava tudo tranquilo.");
        }
    }

    private void batalhar(NPCPokemon inimigo) throws FileNotFoundException {

        System.out.println("--- Batalha Iniciada ---");

        while(pokemon.getHpAtual() > 0 && inimigo.getHpAtual() > 0) {

            boolean vitoria = pokemon.atacar(inimigo);

            if(vitoria) {
                System.out.println("🏆 Você venceu o " + inimigo.getNome() + "!");
                pokemon.ganharXP(50);
                return;
            }

            if (inimigo.getHpAtual() > 0) {
                System.out.println("\n🔻 " + inimigo.getNome() + " contra-ataca!");

                int danoInimigo = inimigo.getAtaque() - pokemon.getDefesa();

                if (danoInimigo < 0) danoInimigo = 0;

                if (danoInimigo == 0) {
                    System.out.println("Sua defesa absorveu quase todo o impacto!");
                    danoInimigo = 4;
                }

                System.out.println("O inimigo causou " + danoInimigo + " de dano!");
                pokemon.receberDano(danoInimigo);

                if (pokemon.getHpAtual() <= 0) {
                    System.out.println("☠️ Seu Pokémon desmaiou...");
                }
            }
        }
    }

    private void treinar() throws FileNotFoundException {
        System.out.println("\n--- CAMPO DE TREINAMENTO ---");
        System.out.println("Escolha seu parceiro de treino");
        System.out.println("1. Cinderace");
        System.out.println("2. Lapras");
        System.out.println("3. Pikachu");
        System.out.println("4. Psyduck");
        System.out.println("5. Voltar");
        System.out.print("Sua escolha: ");

        int escolha = 0;
        if (jogador.hasNextInt()) {
            escolha = jogador.nextInt();
            jogador.nextLine();
        }

        int nivelTreino = pokemon.getLevel();
        if (nivelTreino < 1) {
            nivelTreino = 1;
        }

        String parceiroTreino = "Gardevoir";
        TipoPokemon tipoParceiro = TipoPokemon.PSIQUICO;

        switch (escolha) {
            case 1:
                parceiroTreino = "Cinderace";
                tipoParceiro = TipoPokemon.FOGO;
                break;
            case 2:
                parceiroTreino = "Lapras";
                tipoParceiro = TipoPokemon.AGUA;
                break;
            case 3:
                parceiroTreino = "Pikachu";
                tipoParceiro = TipoPokemon.ELETRICO;
                break;
            case 4:
                parceiroTreino = "Psyduck";
                tipoParceiro = TipoPokemon.PSIQUICO;
                break;
            case 5:
                menuPrincipal();
            default:
                System.out.println("Escolha inválida! Não se preocupe, eu escolhi seu parceiro!");
                break;
        }

        System.out.println("Iniciando treino contra " + parceiroTreino + "...");

        NPCPokemon poketreino = new NPCPokemon( tipoParceiro, parceiroTreino, nivelTreino, 50 + (nivelTreino * 10), 5 + nivelTreino, 5 + nivelTreino, 2 + (nivelTreino / 2), 2 + (nivelTreino / 2));

        batalhar(poketreino);

        System.out.println("O treino acabou! Seu Pokémon ganhou mais experiencia(XP).");
    }

    private void tentarFugir(NPCPokemon inimigo) throws FileNotFoundException {
        System.out.println("Tentando escapar...");
        int sorteFuga = new java.util.Random().nextInt(100);

        if (sorteFuga < 50) {
            System.out.println("💨 SUCESSO! Você fugiu com o rabo entre as pernas.");
        } else {
            System.out.println("🚫 FALHA! O " + inimigo.getNome() + " bloqueou sua passagem!");
            System.out.println("Você foi forçado a lutar!");
            batalhar(inimigo);
        }
    }
}