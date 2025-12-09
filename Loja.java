package Pokegotchi;

import Pokegotchi.Enum.TipoItem;

import java.util.ArrayList;

public class Loja {

    private ArrayList<Item> estoque;

    public Loja(ArrayList<Item> estoque) {
        this.estoque = new ArrayList<>();
    }

    private void adcEstoque () {
        estoque.add(new Item("Super Poção ", TipoItem.CURA, 35.0, "Recupera 100% do HP"));
        estoque.add(new Item("Poção ", TipoItem.CURA, 15.0, "Recupera 30 do HP"));
        estoque.add(new Item("Antídoto ", TipoItem.CURA, 30.0, "Remove veneno e permite atacar o inimigo"));
        estoque.add(new Item("Berries ", TipoItem.BATALHA, 30.0, "Aumenta o ataque do Pokemon em 15!"));
        estoque.add(new Item("Inseto ", TipoItem.BATALHA, 15.0, "Aumenta a defesa do Pokemon em 20!"));
    }

    public void exibirEstoque() {
        System.out.println("\n=== BEM-VINDO À POKÉ-LOJA ===");
        for (int i = 0; i < estoque.size(); i++) {
            Item item = estoque.get(i);
            System.out.print((i + 1) + ". ");
            item.mostrarItem();
        }
    }
}
