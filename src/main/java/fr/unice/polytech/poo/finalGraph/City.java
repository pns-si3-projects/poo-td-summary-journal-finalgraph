package fr.unice.polytech.poo.finalGraph;

import java.util.Objects;

public record City(String nom, double latitude, double longitude) {

    /**
     * Calcule la latitude en radian
     * @return la latitude en radian
     */
    public double radLat() {
        return latitude * (Math.PI / 180);
    }

    /**
     * Calcule la longitude en radian
     * @return la longitude en radian
     */
    public double radLon() {
        return longitude * (Math.PI / 180);
    }

    /**
     * Calcule la distance séparant la ville actuelle à la ville de destination
     * @param dest la ville de destination
     * @return la distance en mètre entre les deux villes
     */
    public double distance(City dest) {
        // Rayon Terre * arccos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1))
        return 6378137 * Math.acos(Math.sin(this.radLat()) * Math.sin(dest.radLat())
                + Math.cos(this.radLat()) * Math.cos(dest.radLat()) * Math.cos(dest.radLon() - this.radLon()));
    }

    @Override
    public String toString() {
        // Nom ville (lat°,lon°)
        return nom + " (" + latitude +
                "°," + longitude + "°)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.latitude, latitude) == 0 && Double.compare(city.longitude, longitude) == 0 && Objects.equals(city.nom, nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, latitude, longitude);
    }
}
