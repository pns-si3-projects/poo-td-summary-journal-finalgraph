package fr.unice.polytech.poo.finalGraph;

import fr.unice.polytech.poo.graph.AbstractGraph;
import fr.unice.polytech.poo.graph.DuplicateTagException;
import fr.unice.polytech.poo.graph.UnDiGraph;
import fr.unice.polytech.poo.graph.Vertex;

import java.util.*;
import java.util.stream.Collectors;

public class CitiesMap {
    private Map<String, City> mapCities;
    UnDiGraph unDiGraph;

    /**
     * Retourne la liste des villes dans la map
     * @return la liste des villes
     */
    public List<City> getCities(){
        return mapCities.values().stream().toList();
    }

    /**
     * Retourne la ville recherchée
     * @param name le nom de la ville voulue
     * @return la ville recherchée
     */
    public City getCity(String name){
        return mapCities.get(name);
    }

    /**
     * Recherche le chemin le plus court pour aller de la ville de départ à la ville de destination en appliquant l'algorithme de dijkstra
     * @param start ville de départ
     * @param dest ville de destination
     * @return la liste des villes par lesquelles on passe en prenant ce chemin
     */
    public List<City> shortestPath(City start, City dest){
        //TODO Cherche le chemin le plus court pour atteindre la ville de destination depuis la ville de départ
        //TODO Renvoie la liste des villes de ce chemin

        return new ArrayList<>();
    }

    /**
     * Cnstruit la carte des villes à partir d'une liste de villes et d'une distance maximale pour relier les villes
     * @param cities la liste de villes à partir de laquelle construire la carte
     * @param distanceMax la distance maximale pour relier 2 villes ensemble
     * @return le graph
     */
    public UnDiGraph buildMap(List<City> cities, double distanceMax){
        mapCities = new HashMap<>(cities.size());
        unDiGraph = new UnDiGraph();

        //TODO Construire la carte en ajoutant les villes de "cities" dans la map et dans le graph en créant des vertex les représentant

        return unDiGraph;
    }

    /**
     * algorithme de dijkstra
     * @param start
     * @param end
     * @return la liste des vertex du chemin
     */
    public List<Vertex> dijkstra(Vertex start, Vertex end) {
        int size = unDiGraph.nbVertices();
        Map<Vertex, Vertex> origin = new HashMap<>(size);
        Map<Vertex, Double> distances = new HashMap<>(size);
        Deque<Vertex> toVisit = new LinkedList<>();

        //TODO Rechercher le chemin le plus court puis le construire

        return new ArrayList<>();
    }

    private void visitDijkstra(Vertex end, Map<Vertex, Vertex> origin,
                                      Map<Vertex, Double> distances, Deque<Vertex> toVisit) {
        Vertex current;
        double curEdjeWeight;

        // TODO parcourir les vertex présents dans toVisit puis parcourir les vertex adjacents jusqu'à arriver au vertex d'arriver.
        // Prendre en compte les distances

    }

    /**
     * Construit le chemin depuis une map de vertex donnée ainsi que le vertex de départ et le vertex d'arriver
     * @param start vertex de départ
     * @param end vertex d'arrivée
     * @param origin map des vertex du chemin
     * @return la liste des vertex par lesquel on passe à travers le chemin créé.
     */
    private List<Vertex> buildPath(Vertex start, Vertex end, Map<Vertex, Vertex> origin) {
        List<Vertex> path = new ArrayList<>();

        //TODO Mettre dans l'attribut "path" la liste des vertex parcouru par le chemin

        // à compléter
        return path;
    }

}
