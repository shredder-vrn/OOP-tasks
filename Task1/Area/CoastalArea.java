package vsu.cs.Task1.Area;

public class CoastalArea extends Area {
    private String waterBodyType;

    public CoastalArea(String name, int latitude, int longitude, String waterBodyType) {
        super(name, latitude, longitude);
        this.waterBodyType = waterBodyType;
    }

    public String getWaterBodyType() {
        return waterBodyType;
    }

    public void setWaterBodyType(String waterBodyType) {
        this.waterBodyType = waterBodyType;
    }

    @Override
    public String toString() {
        return super.getName() + " (Прибрежная зона, Водоём: " + waterBodyType + ")";
    }
}

