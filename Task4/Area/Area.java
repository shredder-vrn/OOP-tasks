package vsu.cs.Task4.Area;

import java.util.Objects;

public abstract class Area {
    private final String name;
    private final int latitude;
    private final int longitude;

    private static final String COUNTRY = "Россия";
    private static int count = 0;
    private final boolean check;
    private final int NUMBER_INSTANCE;

    public Area(String name, int latitude, int longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
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

    @Override
    public String toString() {
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
