package vsu.cs.Task5.Area;

import java.util.Objects;

public class CoastalArea extends Area {
    private String waterBodyType;

    private static int count = 0; // Статичный
    private static final String CLASS_NAME = "CoastalArea"; // Статичный
    private boolean check; // Экземплярный
    private final int numberInstance;  // Экземплярный

    public CoastalArea(String name, int latitude, int longitude, String waterBodyType) {
        super(name, latitude, longitude);
        this.waterBodyType = waterBodyType;
        //System.out.println("Конструктор CoastalArea.");
    }

    static {
        //System.out.println("\nСтатический блок дочернего класса CoastalArea.\n");
    }

    {
        this.check = true;
        numberInstance = ++count;
        //System.out.println("Экземплярный (нестатический) блок дочернего класса CoastalArea.");
    }

    /**
     * equals и hashCode для всех полей
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CoastalArea that = (CoastalArea) o;
        return check == that.check &&
                numberInstance == that.numberInstance &&
                Objects.equals(waterBodyType, that.waterBodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), waterBodyType, check, numberInstance);
    }

    /**
     * equals и hashCode для части полей (name и waterBodyType)
     */

    public boolean equalsByNameAndWaterBody(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoastalArea that = (CoastalArea) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(waterBodyType, that.waterBodyType);
    }

    public int hashCodeByNameAndWaterBody() {
        return Objects.hash(getName(), waterBodyType);
    }

    public String getWaterBodyType() {
        return waterBodyType;
    }

    public void setWaterBodyType(String waterBodyType) {
        this.waterBodyType = waterBodyType;
    }

    @Override
    public boolean isCheck() {
        return check;
    }

    @Override
    public void setCheck(boolean check) {
        this.check = check;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int countCoastalArea) {
        CoastalArea.count = countCoastalArea;
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
    public int getNumberInstance() {
        return numberInstance;
    }

    @Override
    public String toString() {
        return super.getName() + " (Прибрежная зона, Водоём: " + waterBodyType + ")";
    }
}
