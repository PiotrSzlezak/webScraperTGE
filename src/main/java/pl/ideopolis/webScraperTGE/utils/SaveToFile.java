package pl.ideopolis.webScraperTGE.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {

    private static BufferedWriter bw;

    public static void saveToFile (String fileName, String path, String text){
        try {
            bw = new BufferedWriter(new FileWriter(path+fileName));
            bw.write(text);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong while saving to the file.");
            e.printStackTrace();
        }
        System.out.println("File "+fileName+" saved successfully at "+path);
    }

}
