package fr.unice.polytech.poo.finalGraph;

import fr.unice.polytech.poo.graph.DuplicateTagException;
import fr.unice.polytech.poo.graph.UnDiGraph;
import fr.unice.polytech.poo.graph.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<City> shortestPath(City start, City dest){

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

}
