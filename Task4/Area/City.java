package vsu.cs.Task4.Area;

import java.util.Objects;

public class City extends Area {
    private int population;
    private int urbanizationLevel;

    private static final String CLASS_NAME = "City"; // Статичный
    private static int count = 0; // Статичный
    private boolean check; // Экземплярный
    private final int numberInstance;  // Экземплярный

    public City(String name, int latitude, int longitude, int population, int urbanizationLevel) {
        super(name, latitude, longitude);
        this.population = population;
        this.urbanizationLevel = urbanizationLevel;
        //System.out.println("Конструктор дочернего класса City.");
    }

    static {
        //System.out.println("\nСтатический блок дочернего класса City.\n");
    }

    {
        check = true;
        numberInstance = ++count;
        //System.out.println("Экземплярный (нестатический) блок дочернего класса City.");
    }

    /**
     * equals и hashCode, где все поля значимые
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // Используем исправленный equals из Area
        City city = (City) o;
        return population == city.population &&
                urbanizationLevel == city.urbanizationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), population, urbanizationLevel);
    }


    /**
     * equals и hashCode, где часть полей значимые (только name, population, urbanizationLevel)
     */

    public boolean equalsByNameAndStats(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return population == city.population &&
                urbanizationLevel == city.urbanizationLevel &&
                Objects.equals(getName(), city.getName());
    }

    public int hashCodeByNameAndStats() {
        return Objects.hash(getName(), population, urbanizationLevel);
    }

    public int getPopulation() {
        return population;
    }

    public int getUrbanizationLevel() {
        return urbanizationLevel;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setUrbanizationLevel(int urbanizationLevel) {
        this.urbanizationLevel = urbanizationLevel;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        City.count = count;
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public String getParentClassName() {
        Class<?> parentClass = this.getClass().getSuperclass();
        return parentClass != null ? parentClass.getSimpleName() : "Нет родительского класса";
    }

    @Override
    public boolean isCheck() {
        return check;
    }

    @Override
    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public int getNumberInstance() {
        return numberInstance;
    }

    @Override
    public String toString() {
        return super.getName() + " (Город, Население: " + population + ", Уровень урбанизации: " + urbanizationLevel + "%)";
    }
}
