package vsu.cs.Task7.Area;

import vsu.cs.Task7.Interfaces.Geographical;
import vsu.cs.Task7.LocationType;

import java.util.Objects;

public abstract class Area implements Geographical {
    private final String name;
    private final int latitude;  // Широта (-90 до 90)
    private final int longitude; // Долгота (-180 до 180)


    private static final String COUNTRY = "Россия";
    private static int count = 0;
    private final boolean check;
    private final int NUMBER_INSTANCE;

    private final LocationType locationType;


    public Area(String name, int latitude, int longitude, LocationType locationType) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationType = locationType;
        //System.out.println("Конструктор Area.");
    }

    static {
        //System.out.println("\n" + COUNTRY + "\nСтатический блок родительского класса Area.");
    }

    {
        this.check = true;
        NUMBER_INSTANCE = ++count;
        //System.out.println("Экземплярный (нестатический) блок родительского класса Area.");
    }

    /**
     * equals и hashCode, где все поля значимые
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return latitude == area.latitude &&
                longitude == area.longitude &&
                Objects.equals(name, area.name); // Используем только значимые поля
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude); // Используем только значимые поля
    }


    /**
     * equals и hashCode, где часть полей значимые (name и координаты)
     */

    public boolean equalsByNameAndCoordinates(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return latitude == area.latitude &&
                longitude == area.longitude &&
                Objects.equals(name, area.name);
    }

    public int hashCodeByNameAndCoordinates() {
        return Objects.hash(name, latitude, longitude);
    }

    public String getName() {
        return name;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public static int getCount() {
        return count;
    }

    public boolean isCheck() {
        return check;
    }

    public int getNUMBER_INSTANCE() {
        return NUMBER_INSTANCE;
    }

    public abstract void setCheck(boolean check);

    public abstract int getNumberInstance();

    public LocationType getLocationType() {
        return locationType;
    }

    /*@Override
    public String toString() {
        return "Родительский";
    }*/

    @Override
    public String toString() {
        return name + " (Широта: " + latitude + ", Долгота: " + longitude + ")";
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public String getParentClassName() {
        Class<?> parentClass = this.getClass().getSuperclass();
        return parentClass != null ? parentClass.getSimpleName() : "Нет родительского класса";
    }

    @Override
    public double calculateDistance(int latitude, int longitude) {
        double latDiff = this.latitude - latitude;
        double lonDiff = this.longitude - longitude;
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff); // Простая евклидова метрика
    }

    @Override
    public boolean isWithinRange(int latitude, int longitude, int range) {
        return calculateDistance(latitude, longitude) <= range;
    }
}
