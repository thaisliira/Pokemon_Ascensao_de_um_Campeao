package Pokegotchi;

import Pokegotchi.Enum.TipoItem;

public class Item {

    private String nome;
    private TipoItem item;
    private Double preco;
    private String descEfeito;
    private int efeito;

    public Item(String nome, TipoItem item, Double preco, String descEfeito, int efeito) {
        this.nome = nome;
        this.item = item;
        this.preco = preco;
        this.descEfeito = descEfeito;
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

    public String getDescEfeito() {
        return descEfeito;
    }

    public int getEfeito() {
        return efeito;
    }

    /**
     * Função que exibe o nome do item, preço e descrição do efeito
     */
    public void mostrarItem() {
        System.out.println("- " + nome + " (" + preco + "$): " + descEfeito);
    }
}
