package Pokegotchi.Enum;

public enum Mapa {

    FLORESTA("Floresta Viridian", TipoPokemon.TERRA),
    VULCAO("Parque do Vulcão Cinnabar", TipoPokemon.FOGO),
    LAGO("Lago da Fúria", TipoPokemon.AGUA),
    USINA("Usina de Choque", TipoPokemon.ELETRICO);

    private String nome;
    private TipoPokemon tipoInimigo;

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