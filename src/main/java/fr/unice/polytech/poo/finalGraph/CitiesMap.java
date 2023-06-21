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
     * Recherche le chemin le plus court pour aller de la ville de départ à la ville de destination
     * @param start ville de départ
     * @param dest ville de destination
     * @return la liste des villes par lesquelles on passe en prenant ce chemin
     */
    public List<City> shortestPath(City start, City dest){
        Vertex verStart = unDiGraph.getVertex(start.nom());
        Vertex verDest = unDiGraph.getVertex(dest.nom());
        List<Vertex> path = dijkstra(verStart, verDest);
        return path.stream().map((vertex -> mapCities.get(vertex.getTag()))).collect(Collectors.toList());
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

        for (City city: cities){
            try {
                String cityNom = city.nom();
                unDiGraph.addVertex(cityNom);

                for (City inGraphCity: mapCities.values()){
                    double distance = city.distance(inGraphCity);
                    if (distance <= distanceMax){
                        unDiGraph.addEdge(unDiGraph.getVertex(cityNom), unDiGraph.getVertex(inGraphCity.nom()), distance);
                    }
                }

                mapCities.put(cityNom, city);
            }

            catch (DuplicateTagException e){
                throw new IllegalArgumentException(e);
            }
        }
        return unDiGraph;
    }

    /**
     * l'algorithme de dijkstra
     * @param start
     * @param end
     * @return la liste des vertex du chemin
     */
    public List<Vertex> dijkstra(Vertex start, Vertex end) {
        int size = unDiGraph.nbVertices();
        Map<Vertex, Vertex> origin = new HashMap<>(size);
        Map<Vertex, Double> distances = new HashMap<>(size);
        Deque<Vertex> toVisit = new LinkedList<>();

        origin.put(start, start);
        toVisit.add(start);
        distances.put(start, 0.0);
        visitDijkstra(end, origin, distances, toVisit);
        return buildPath(start, end, origin);
    }

    private void visitDijkstra(Vertex end, Map<Vertex, Vertex> origin,
                                      Map<Vertex, Double> distances, Deque<Vertex> toVisit) {
        Vertex current;
        double curEdjeWeight;

        while (!toVisit.isEmpty()) {
            current = toVisit.pop();
            if (current.equals(end)) {
                return;
            }

            for (Vertex adjacent : unDiGraph.adjacents(current)) {
                if (!origin.containsKey(adjacent)) {
                    toVisit.add(adjacent);
                }

                curEdjeWeight = distances.get(current) + unDiGraph.findEdge(current, adjacent).weight();
                if (!distances.containsKey(adjacent) || distances.get(adjacent) > curEdjeWeight) {
                    distances.put(adjacent, curEdjeWeight);
                    origin.put(adjacent, current);
                }
            }
        }
    }

    private List<Vertex> buildPath(Vertex start, Vertex end, Map<Vertex, Vertex> origin) {
        List<Vertex> path = new ArrayList<>();

        while (origin.containsKey(end) && !end.equals(start)) {
            path.add(0, end);
            end = origin.get(end);
        }

        if (end.equals(start)) {
            path.add(0, start);
        }
        return path;
    }

}
