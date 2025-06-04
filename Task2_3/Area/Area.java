package vsu.cs.Task2_3.Area;

import java.util.Objects;

public class Area {
    // Инлайн инициализаторы полей
    private String name;
    private int latitude;
    private int longitude;

    private static final String COUNTRY = "Россия"; // Статичный
    private static int count = 0; // Статичный
    private boolean check; // Экземплярный
    private final int NUMBER_INSTANCE;  // Экземплярный

    public Area(String name, int latitude, int longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        System.out.println("Конструктор Area.");
    }

    static {
        System.out.println("\n"+ COUNTRY +"\nСтатический блок родительского класса Area.");
    }

    {
        this.check = true;
        NUMBER_INSTANCE = ++count;
        System.out.println("Экземплярный(нестатический) блок родительского класса Area.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return latitude == area.latitude && longitude == area.longitude && check == area.check && NUMBER_INSTANCE == area.NUMBER_INSTANCE && Objects.equals(name, area.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude, check, NUMBER_INSTANCE);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getNumberInstance() {
        return NUMBER_INSTANCE;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Area.count = count;
    }

    @Override
    public String toString(){
        return "Родительский";
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public String getParentClassName() {
        Class<?> parentClass = this.getClass().getSuperclass();
        return parentClass != null ? parentClass.getSimpleName() : "Нет родительского класса";
    }
}