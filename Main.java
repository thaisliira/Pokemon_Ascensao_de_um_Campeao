package Pokegotchi;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Game game = new Game();
        game.iniciar();
    }
}