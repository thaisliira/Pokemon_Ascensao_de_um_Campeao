package Pokegotchi;

import Pokegotchi.Enum.TipoItem;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Item> itens;

    public Inventario(ArrayList<Item> itens) {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println(item.getNome() + " foi adicionado à mochila!");
    }

    public Item usarItem(int numItem) {
        if (numItem >= 0 && numItem < itens.size()) {
            return itens.remove(numItem);
        }
        return null;
    }
}
