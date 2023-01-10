package pk.rpgame.model.singleton;

import pk.rpgame.model.items.Item;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AccessSaveFile {
    private static AccessSaveFile instance = null;
    File file;

    private AccessSaveFile() {
        file = new File("data.txt");
    }

    public static AccessSaveFile getInstance() {
        if (instance == null) {
            instance = new AccessSaveFile();
        }

        return instance;
    }

    private void fillSaveFileIfNotExist() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fw = new FileWriter(file, false);
                BufferedWriter writer = new BufferedWriter(fw);

                writer.write("!!!!Hall of fame!!!!\n");
                writer.write("\n====================\n\n");

                writer.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveData(String name, Double HP, Double strength, List<Item> items) {
        fillSaveFileIfNotExist();

        if (file.canWrite()) {
            try {
                FileWriter fw = new FileWriter(file, false);
                BufferedWriter writer = new BufferedWriter(fw);

                writer.write("Hero name: " + name + "\n");
                writer.write("Hero HP was equal: " + HP.toString() + "\n");
                writer.write("Hero strength was equal: " + strength.toString() + "\n");
                writer.write("\nIn his inventory was: \n");

                for (Item item : items) {
                    writer.write("Item name: " + item.getName());

                }

                // zamknięcie pliku
                writer.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> loadData() {
        fillSaveFileIfNotExist();

        try {
            List<String> fileList = Files.readAllLines(Paths.get("data.txt"));
            return fileList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
