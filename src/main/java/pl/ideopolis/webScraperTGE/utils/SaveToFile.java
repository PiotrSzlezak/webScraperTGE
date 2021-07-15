package pl.ideopolis.webScraperTGE.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {

    private static BufferedWriter bw;
    private final static Logger log = LoggerFactory.getLogger(SaveToFile.class);

    public static void saveToFile(String fileName, String path, String text) {
        log.trace("saveToFile method.");
        log.trace("fileName = " + fileName + " ,path = " + path);
        try {
            bw = new BufferedWriter(new FileWriter(path + fileName));
            bw.write(text);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            log.error("Something went wrong while saving to the file." + e);
            e.printStackTrace();
        }
        log.info("File " + fileName + " saved successfully at " + path);
    }

}
