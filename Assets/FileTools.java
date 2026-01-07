package Pokemon_Ascensao.Assets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe para impressão da arte do pokémon inicial e após evoluções
 */
public class FileTools {

    /**
     * Função para imprimir a arte do pokemon
     * @param path local da arte
     * @throws FileNotFoundException se não encontrar o arquivo
     */
    public static void printFile(String path) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(path));

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}