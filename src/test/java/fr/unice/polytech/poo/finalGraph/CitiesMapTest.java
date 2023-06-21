package fr.unice.polytech.poo.finalGraph;

import fr.unice.polytech.poo.finalGraph.CitiesMap;
import fr.unice.polytech.poo.finalGraph.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CitiesMapTest {
    private City st_etienne;
    private City st_paul_en_jarez;
    private City st_chamond;
    private City lyon;
    private City grenoble;
    private CitiesMap citiesMap;

    @BeforeEach
    void setup() {
        st_etienne = new City("Saint-Etienne", 45.43022811, 4.378746004);
        st_paul_en_jarez = new City("Saint-Paul-En-Jarez", 45.470167276, 4.578761772);
        st_chamond = new City("Saint Chamond", 45.470082658,4.502048914);
        lyon = new City("Lyon", 45.733906132, 4.868941686);
        grenoble = new City("Grenoble", 45.182206145, 5.7212206420000005);
        citiesMap = new CitiesMap();
        List<City> list = new ArrayList<>();
        list.add(st_etienne);
        list.add(st_chamond);
        list.add(st_paul_en_jarez);
        list.add(lyon);
        list.add(grenoble);
        double distMax = st_paul_en_jarez.distance(lyon);
        citiesMap.buildMap(list, distMax);
    }

    @Test
    void getCities() {
        assertEquals(5, citiesMap.getCities().size());
    }

    @Test
    void getCity() {
        assertEquals(st_etienne, citiesMap.getCity("Saint-Etienne"));
        assertNotEquals(st_paul_en_jarez, citiesMap.getCity("Lyon"));
    }

    @Test
    void buildMap() {
        assertEquals(5,citiesMap.unDiGraph.nbVertices());
        assertEquals(4, citiesMap.unDiGraph.nbEdges());
    }

    @Test
    void shortestPath() {
        List<City> st_etienne_to_lyon = citiesMap.shortestPath(st_etienne, lyon);
        assertEquals(3, st_etienne_to_lyon.size());
    }

    @Test
    void test() {
        CityCSVParser cityCSVParser = new CityCSVParser("data/cities.csv");
        List<City> cities = cityCSVParser.parseCities(4, 5, 6);
        List<City> citiesReduced = cities.stream().limit(3000).collect(Collectors.toList());
        CitiesMap allCitiesMap = new CitiesMap();
        allCitiesMap.buildMap(citiesReduced, 150000);
        System.out.println(allCitiesMap.unDiGraph.nbVertices());
        System.out.println(allCitiesMap.unDiGraph.nbEdges());

        List<City> shortestPath = allCitiesMap.shortestPath(citiesReduced.get(1), citiesReduced.get(20));
        System.out.println(shortestPath);
    }
}