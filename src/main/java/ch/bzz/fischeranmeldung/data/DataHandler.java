package ch.bzz.fischeranmeldung.data;

import ch.bzz.fischeranmeldung.model.Angler;
import ch.bzz.fischeranmeldung.model.Fische;
import ch.bzz.fischeranmeldung.service.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * data handler for reading and writing the csv files
 *
 * M133: Fischeranmeldung
 *
 * @date 08.03.2021
 * @author Anid Memisi
 * @version 1.0
 */

public class DataHandler {
    private static final DataHandler instance = new DataHandler();
    private static Map<String, Angler> anglerMap;
    private static Map<Integer, Fische> fischeMap;

    /**
     * default constructor: defeat instantiation
     */
    private DataHandler() {
        anglerMap = new HashMap<>();
        fischeMap = new HashMap<>();
        readJSON();
    }

    /**
     * reads a single fisher identified by its id
     * @param fischerLizenz  the identifier
     * @return angler-object
     */
    public static Angler readAngler(String fischerLizenz) {
        Angler angler = new Angler();
        if (getAnglerMap().containsKey(fischerLizenz)) {
            angler = getAnglerMap().get(fischerLizenz);
        }
        return angler;
    }

    /**
     * saves a fisher
     * @param angler to be saved
     */
    public static void saveAngler(Angler angler) {
        getAnglerMap().put(angler.getLizenz(), angler);
        writeJSON();
    }

    /**
     * reads a single fisch identified by its id
     * @param wert  the identifier
     * @return fisch-object
     */
    public static Fische readFische(int wert) {
        Fische fisch = new Fische();

        if (getFischeMap().containsKey(wert)) {
            fisch = getFischeMap().get(wert);
        }
        return fisch;
    }

    /**
     * saves a fische
     * @param fisch  the fisch to be saved
     */
    public static void saveFish(Fische fisch) {
        getFischeMap().put(fisch.getWert(), fisch);
        writeJSON();
    }

    /**
     * gets the AnglerMap
     * @return the AnglerMap
     */
    public static Map<String, Angler> getAnglerMap() {
        return anglerMap;
    }

    /**
     * gets the fischeMap
     * @return the AnglerMap
     */
    public static Map<Integer, Fische> getFischeMap() {
        return fischeMap;
    }
    public static void setFischeMap(Map<Integer, Fische> fischeMap) { DataHandler.fischeMap = fischeMap; }
    public static void setAnglerMap(Map<String, Angler> anglerMap) {
        DataHandler.anglerMap = anglerMap;
    }

    /**
     * reads the angler and fische
     */
    private static void readJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(Config.getProperty("anglerJSON")));
            ObjectMapper objectMapper = new ObjectMapper();
            Angler[] anglers = objectMapper.readValue(jsonData, Angler[].class);
            for (Angler angler : anglers) {
                Collection<Fische> fische = null;
                for(Fische fisch : angler.getGefangeneFische()){
                    int fischerLizenz= fisch.getWert();
                    if (getFischeMap().containsKey(fisch.getWert())) {
                        fisch = getFischeMap().get(fisch.getWert());
                    } else {
                        getFischeMap().put(fisch.getWert(), fisch);
                    }
                    fische.add(fisch);
                }
                angler.setGefangeneFische(fische);
                getAnglerMap().put(angler.getLizenz(), (Angler) fische);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * write the fisher and fish
     *
     */
    private static void writeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        Writer writer;
        FileOutputStream fileOutputStream = null;

        String anglerPath = Config.getProperty("anglerJSON");
        try {
            fileOutputStream = new FileOutputStream(anglerPath);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectMapper.writeValue(writer, getAnglerMap().values());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

