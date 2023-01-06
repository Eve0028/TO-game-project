package pk.rpgame.model.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class AccessSaveFile {
    private static AccessSaveFile instance=null;
    File file;

    private AccessSaveFile(){
        file=new File("data.txt");
    }

    public static AccessSaveFile getInstance(){
        if(instance==null){
            instance=new AccessSaveFile();
        }

        return instance;
    }

    public void saveData(/*argumenty do dodania co bedziemy zapisywać*/){
        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        if(file.canWrite()) {
            try {
                FileWriter fw = new FileWriter(file, true);
                Formatter fm= new Formatter(fw);
                Scanner sf= new Scanner(file);

                /* fm.format(*//*zapis argumentów do pliku (typ)*//*,*//*argumenty*//*);*/

                //zamknięcie pliku
                fm.close();
                fw.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public List<String> loadData(){
        try{
            List<String> fileList= Files.readAllLines(Paths.get("data.txt"));
            return fileList;
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }


}
