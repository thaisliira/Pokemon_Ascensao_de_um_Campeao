package Pokemon_Ascensao;

import Pokemon_Ascensao.Enum.TipoItem;

/**
 * Classe que adiciona atributos aos itens que estão na loja ou inventário
 */
public class Item {

    private final String nome;
    private final TipoItem item;
    private final Double preco;
    private final String descEfeito;
    private final int efeito;

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
        System.out.println(nome + " (" + preco + "$): " + descEfeito);
    }
}
