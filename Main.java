package Pokemon_Ascensao;

import Pokemon_Ascensao.Game.Game;

import java.io.FileNotFoundException;

/**
 * Função principal que inicia o jogo
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Game game = new Game();
        game.iniciar();
    }
}