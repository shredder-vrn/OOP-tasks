package vsu.cs.Task6;

import vsu.cs.Task6.Area.Area;
import vsu.cs.Task6.Weather.Weather;

import java.util.Objects;

public class WeatherOnArea {

    private Weather weather;
    private Area area;

    public WeatherOnArea(Weather weather, Area area) {
        if (weather == null || area == null) {
            throw new IllegalArgumentException("Погода и область не могут быть null.");
        }
        this.weather = weather;
        this.area = area;
        //System.out.println("Конструктор WeatherOnArea.");
    }

    static {
        //System.out.println("\nСтатический блок класса WeatherOnArea.\n");
    }

    {
        //System.out.println("Экземплярный блок класса WeatherOnArea.");
    }

    /**
     * Переопределение equals для сравнения объектов WeatherOnArea.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherOnArea that = (WeatherOnArea) o;
        return Objects.equals(weather, that.weather) && Objects.equals(area, that.area);
    }

    /**
     * Переопределение hashCode для создания хэш-кода.
     */
    @Override
    public int hashCode() {
        return Objects.hash(weather, area);
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        if (weather == null) {
            throw new IllegalArgumentException("Погода не может быть null.");
        }
        this.weather = weather;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        if (area == null) {
            throw new IllegalArgumentException("Область не может быть null.");
        }
        this.area = area;
    }

    public void printInfo() {
        System.out.println("Область: " + area.toString());
        System.out.println("Погода: " + weather.toString());
    }

    @Override
    public String toString() {
        return String.format("WeatherOnArea [Область: %s, Погода: %s]", area.toString(), weather.toString());
    }
}
