package vsu.cs.Task7.Area;

import vsu.cs.Task7.Exceptions.DuplicateAreaException;
import vsu.cs.Task7.Exceptions.InvalidLocationException;
import vsu.cs.Task7.LocationType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CoastalArea extends Area {
    private String waterBodyType;

    private static final String CLASS_NAME = "CoastalArea"; // Статичный
    private static final Set<CoastalArea> coastalRegistry = new HashSet<>();

    public CoastalArea(String name, int latitude, int longitude, String waterBodyType) throws Exception {
        super(name, latitude, longitude, LocationType.COASTAL);
        this.waterBodyType = waterBodyType;

        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            throw new InvalidLocationException("Координаты прибрежной зоны некорректны.");
        }

        if (!coastalRegistry.add(this)) {
            throw new DuplicateAreaException("Прибрежная зона с такими же атрибутами уже существует: " + name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CoastalArea that = (CoastalArea) o;
        return Objects.equals(waterBodyType, that.waterBodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), waterBodyType);
    }

    @Override
    public void setCheck(boolean check) {

    }

    @Override
    public int getNumberInstance() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(
                "%s (Тип: %s, Водоём: %s)",
                super.toString(), getLocationType(), waterBodyType
        );
    }

    public String getWaterBodyType() {
        return waterBodyType;
    }

    public void setWaterBodyType(String waterBodyType) {
        this.waterBodyType = waterBodyType;
    }

    public static int getRegistryCount() {
        return coastalRegistry.size();
    }
}
