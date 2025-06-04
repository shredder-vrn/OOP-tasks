package vsu.cs.Task2_3.Area;

public class CoastalArea extends Area {
    private String waterBodyType;

    private static int count = 0; // Статичный
    private static final String className = "CoastalArea"; // Статичный
    private boolean check; // Экземплярный
    private final int numberInstance;  // Экземплярный

    public CoastalArea(String name, int latitude, int longitude, String waterBodyType) {
        super(name, latitude, longitude);
        this.waterBodyType = waterBodyType;
        System.out.println("Конструктор CoastalArea.");
    }

    static {
        System.out.println("\nСтатический блок дочерннего класса CoastalArea.\n");
    }


    {
        this.check = true;
        numberInstance = ++count;
        System.out.println("Экземплярный(нестатический) блок дочерннего класса CoastalArea.");
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
        return className;
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