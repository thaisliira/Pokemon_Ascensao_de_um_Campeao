package Pokegotchi;

import Pokegotchi.Enum.TipoItem;

import java.util.ArrayList;

public class Loja {

    private ArrayList<Item> estoque;

    public Loja() {
        this.estoque = new ArrayList<>();

        estoque.add(new Item("Super Poção", TipoItem.CURA, 35.0, ": Recupera 100% do HP", 100));
        estoque.add(new Item("Poção Pequena", TipoItem.CURA, 15.0, ": Recupera 30 HP", 30));
        estoque.add(new Item("Pílula de Força", TipoItem.ATAQUE, 30.0, ": Aumenta Ataque em 15",15));
        estoque.add(new Item("Goma de Defesa", TipoItem.DEFESA, 30.0, ": Aumenta Defesa em 20",20));
        estoque.add(new Item("Doce Raro", TipoItem.NIVEL, 50.0, ": Sobe 1 Nível instantaneamente",1));
    }

    public ArrayList<Item> getEstoque() {
        return estoque;
    }

    /**
     * Função que permite exibir o estoque da loja
     */
    public void exibirEstoque() {
        for (int i = 0; i < estoque.size(); i++) {
            Item itemLoja = estoque.get(i);
            System.out.print((i + 1) + ". ");
            itemLoja.mostrarItem();
        }
    }
}
