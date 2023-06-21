package fr.unice.polytech.poo.finalGraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityCSVParserTest {
    private String fileCities;
    private String fileVilles;
    private CityCSVParser cCSVPCities;
    private CityCSVParser cCSVPVilles;

    @BeforeEach
    void setUp() {
        fileCities = "data/cities.csv";
        fileVilles = "data/villes_france.csv";
        cCSVPCities = new CityCSVParser(fileCities);
        cCSVPVilles = new CityCSVParser(fileVilles);
    }

    @Test
    void parseCities() {
        List<City> cities = cCSVPCities.parseCities(4, 5, 6);
        List<City> villes = cCSVPVilles.parseCities(5, 20, 19);
        assertEquals(38934, cities.size());
        assertEquals(36700, villes.size());
        assertEquals("antibes", cities.get(8599).nom());
        assertEquals("antibes", villes.get(1999).nom());
    }
}