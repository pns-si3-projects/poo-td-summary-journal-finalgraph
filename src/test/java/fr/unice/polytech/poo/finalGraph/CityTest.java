package fr.unice.polytech.poo.finalGraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {
    private City slv;
    private City slm;

    @BeforeEach
    void setUp() {
        slv = new City("st laurent du var", 43.686382321, 7.182232303);
        slm = new City("st laurent de mure", 45.683806879, 5.060897249);
    }

    @Test
    void radLat() {
        assertEquals(0.7624712097864924, slv.radLat());
        assertEquals(0.7973328448837848, slm.radLat());
    }

    @Test
    void radLon() {
        assertEquals(0.125353601330445, slv.radLon());
        assertEquals(0.0883293201001733, slm.radLon());
    }

    @Test
    void distance() {
        assertEquals(278597.6475554664, slv.distance(slm));
    }

    @Test
    void testEquals() {
        City slvBis = new City("st laurent du var", 43.686382321, 7.182232303);
        City slvCopy = slv;

        assertEquals(slv, slvBis);
        assertEquals(slv, slvCopy);
        assertNotEquals(slv, slm);
    }
}