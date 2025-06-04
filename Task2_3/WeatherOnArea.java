package vsu.cs.Task2_3;

import vsu.cs.Task2_3.Area.Area;
import vsu.cs.Task2_3.Weather.Weather;


public class WeatherOnArea {

    private Weather weather;
    private Area area;

    public WeatherOnArea(Weather weather, Area area) {
        this.weather = weather;
        this.area = area;
        System.out.println("Конструктор WeatherOnArea.");
    }

    static {
        System.out.println("\nСтатический блок класса WeatherOnArea.\n");
    }


    {
        System.out.println("Экземплярный(нестатический) блок класса WeatherOnArea.");
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    // Добавляем метод printInfo
    public void printInfo() {
        System.out.println("Область: " + area.toString());
        weather.printInfo();
    }

    @Override
    public String toString() {
        return "WeatherOnArea{" +
                "weather=" + weather +
                ", area=" + area +
                '}';
    }
}


