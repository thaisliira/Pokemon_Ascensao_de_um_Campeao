package Pokegotchi.Enum;

public enum Mapa {

    FLORESTA("Floresta Viridian", TipoPokemon.TERRA),
    VULCAO("Vulcão em Chamas", TipoPokemon.FOGO),
    LAGO("Lago Sombrio", TipoPokemon.AGUA),
    USINA("Usina Elétrica", TipoPokemon.ELETRICO);

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