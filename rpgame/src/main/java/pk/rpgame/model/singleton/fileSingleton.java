package pk.rpgame.model.singleton;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class fileSingleton {

    private static fileSingleton instance=null;
    File file;

    private fileSingleton(){
        file=new File("data.txt");
    }

    public static fileSingleton getInstance(){
        if(instance==null){
            instance=new fileSingleton();
        }

        return instance;
    }

    public void save_data(/*argumenty do dodania co bedziemy zapisywać*/){
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


    public List<String> load_data(){
        try{
            List<String> fileList= Files.readAllLines(Paths.get("data.txt"));
            return fileList;
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

}

