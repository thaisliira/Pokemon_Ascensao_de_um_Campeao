package Pokemon_Ascensao.Enum;

/**
 * Enumeração com as opções de habitats que existem no jogo
 */
public enum Mapa {

    FLORESTA("Floresta Viridian", TipoPokemon.PLANTA),
    VULCAO("Parque do Vulcão Cinnabar", TipoPokemon.FOGO),
    LAGO("Lago da Fúria", TipoPokemon.AGUA),
    USINA("Usina de Choque", TipoPokemon.ELETRICO);

    private final String nome;
    private final TipoPokemon tipoInimigo;

    Mapa(String nome, TipoPokemon tipoInimigo) {
        this.nome = nome;
        this.tipoInimigo = tipoInimigo;
    }

    public String getNome() {
        return nome;
    }

    public TipoPokemon getTipoInimigo() {
        return tipoInimigo;
    }

}