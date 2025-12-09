package Pokegotchi;

import Pokegotchi.Enum.TipoItem;

import java.util.ArrayList;

public class Loja {

    private ArrayList<Item> estoque;

    public Loja() {
        this.estoque = new ArrayList<>();

        estoque.add(new Item("Super Poção", TipoItem.CURA, 35.0, "Recupera 100% do HP"));
        estoque.add(new Item("Poção Pequena", TipoItem.CURA, 15.0, "Recupera 30 HP"));
        estoque.add(new Item("Antídoto", TipoItem.CURA, 30.0, "Remove veneno"));
        estoque.add(new Item("Pílula de Força", TipoItem.BATALHA, 30.0, "Aumenta Ataque em 15"));
        estoque.add(new Item("Goma de Defesa", TipoItem.BATALHA, 30.0, "Aumenta Defesa em 20"));
        estoque.add(new Item("Doce Raro", TipoItem.BATALHA, 100.0, "Sobe 1 Nível instantaneamente"));
    }

    public ArrayList<Item> getEstoque() {
        return estoque;
    }

    public void exibirEstoque() {
        for (int i = 0; i < estoque.size(); i++) {
            Item item = estoque.get(i);
            System.out.print((i + 1) + ". ");
            item.mostrarItem();
        }
    }
}
