package Pokegotchi;

import Pokegotchi.Enum.TipoItem;

public class Item {

    private String nome;
    private TipoItem item;
    private Double preco;
    private String efeito;

    public Item(String nome, TipoItem item, Double preco, String efeito) {
        this.nome = nome;
        this.item = item;
        this.preco = preco;
        this.efeito = efeito;
    }

    public String getNome() {
        return nome;
    }

    public TipoItem getItem() {
        return item;
    }

    public Double getPreco() {
        return preco;
    }

    public String getEfeito() {
        return efeito;
    }

    public void mostrarItem() {
        System.out.println("- " + nome + " (" + preco + "$): " + efeito);
    }
}
