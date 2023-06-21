package fr.unice.polytech.poo.finalGraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CityCSVParser {
    private final List<String[]> cities;

    /**
     * Constructeur
     *
     * @param fileName le nom du fichier CSV (avec virgules) à utiliser.
     *                 Doit contenir le nom de la ville, la latitude et la longitude en degrés
     */
    public CityCSVParser(String fileName) {
        try {
            BufferedReader bufferedReader;
            if (fileName.startsWith("http://")) {
                bufferedReader = new BufferedReader(new InputStreamReader(
                        new URL(fileName).openStream(), StandardCharsets.UTF_8));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),
                        StandardCharsets.UTF_8));
            }

            bufferedReader.readLine(); // Passe le header du CSV

            //TODO Mettre dans l'attribut "cities" la liste des villes (sous forme de tableau)
            /*
             * Une ville est représentée par une ligne
             * Les données d'une ville sont séparés par une virgule (CSV avec virgules)
             * Il faut s'assurer qu'il n'y a plus de '"' (double guillemets)
            */
            cities = new ArrayList<>(); // à modifier
        } catch (IOException e) {
            throw new IllegalArgumentException("unreadable file", e);
        }
    }

    /**
     * Renvoie toutes les villes, construites selon les indices donnés en paramètre
     * Pas besoin de trier les lignes, juste les transformer en villes
     *
     * @param nameInd le numéro de la colonne du nom de la ville (de préférence le plus long) {@code nameInd >= 1}
     * @param latInd  le numéro de la colonne de la latitude en degrés {@code latInd >= 1}
     * @param lonInd  le numéro de la colonne de la longitude en degrés {@code lonInd >= 1}
     * @return la liste des villes (sans doublons)
     */
    public List<City> parseCities(int nameInd, int latInd, int lonInd) {
        return new ArrayList<>();
    }
}
