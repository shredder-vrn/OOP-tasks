package vsu.cs.Task1.Area;

public class City extends Area {
    private int population;
    private int urbanizationLevel;

    public City(String name, int latitude, int longitude, int population, int urbanizationLevel) {
        super(name, latitude, longitude);
        this.population = population;
        this.urbanizationLevel = urbanizationLevel;
    }

    public int getPopulation() {
        return population;
    }

    public int getUrbanizationLevel() {
        return urbanizationLevel;
    }

    @Override
    public String toString() {
       return super.getName() + " (Город, Население: " + population + ", Уровень урбанизации: " + urbanizationLevel + "%)";
    }
}

