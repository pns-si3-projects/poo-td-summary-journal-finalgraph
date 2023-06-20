package fr.unice.polytech.poo.finalGraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CityCSVParser {
    private final List<String[]> cities;

    /**
     * Constructeur
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

            bufferedReader.readLine();
            // Prend chaque ligne et les sépare par la virgule (CSV avec virgules)
            cities = bufferedReader.lines().map(s -> s.split(",")).toList();
        } catch (IOException e) {
            throw new IllegalArgumentException("unreadable file", e);
        }
    }

    /**
     * Renvoie toutes les villes, construites selon les indices donnés en paramètre
     * @param nameInd l'indice du nom de la ville (de préférence le plus long)
     * @param latInd l'indice de la latitude en degrés
     * @param lonInd l'indice de la longitude en degrés
     * @return la liste des villes (sans doublons)
     */
    public List<City> parseCities(int nameInd, int latInd, int lonInd) {
        return cities.parallelStream()
                .map(strings -> new City(strings[nameInd], Double.parseDouble(strings[latInd]),
                        Double.parseDouble(strings[lonInd])))
                .distinct()
                .toList();
    }
}
