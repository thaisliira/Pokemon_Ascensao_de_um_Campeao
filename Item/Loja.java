package Pokemon_Ascensao.Item;

import Pokemon_Ascensao.Assets.ConsoleColors;
import Pokemon_Ascensao.Enum.TipoItem;

import java.util.ArrayList;

/**
 * Classe com os itens existentes na loja para venda
 */
public class Loja {

    private final ArrayList<Item> estoque;

    public Loja() {
        this.estoque = new ArrayList<>();

        estoque.add(new Item(ConsoleColors.PURPLE_BOLD + "Super Poção" + ConsoleColors.RESET, TipoItem.CURA, 35.0, "Recupera 100% do HP", 100));
        estoque.add(new Item(ConsoleColors.PURPLE_BOLD + "Poção Pequena" + ConsoleColors.RESET, TipoItem.CURA, 15.0, "Recupera 30 HP", 30));
        estoque.add(new Item(ConsoleColors.PURPLE_BOLD + "Pílula de Força" + ConsoleColors.RESET, TipoItem.ATAQUE, 30.0, "Aumenta Ataque em 15",15));
        estoque.add(new Item(ConsoleColors.PURPLE_BOLD + "Goma de Defesa" + ConsoleColors.RESET, TipoItem.DEFESA, 30.0, "Aumenta Defesa em 20",20));
        estoque.add(new Item(ConsoleColors.PURPLE_BOLD + "Doce Raro" + ConsoleColors.RESET, TipoItem.NIVEL, 50.0, "Sobe 1 Nível instantaneamente",1));
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
