package vsu.cs.Task1;

import vsu.cs.Task1.Area.Area;
import vsu.cs.Task1.Area.City;
import vsu.cs.Task1.Area.CoastalArea;
import vsu.cs.Task1.Weather.*;


public class Main {
    public static void main(String[] args) {
        // Погода
        Weather snowyWeather = new SnowyWeather(0, 85, 10, "Северный", 90, "Снежно", "Снежная иконка");
        Weather rainyWeather = new RainyWeather(12, 90, 15, "Южный", 80, "Дождливо", "Дождевая иконка");
        Weather sunnyWeather = new SunnyWeather(25, 60, 5, "Западный", 0, "Солнечно", "Солнечная иконка");
        Weather foggyWeather = new FoggyWeather(8, 100, 0, "Тихий", 20, "Туманно", "Туманная иконка");

        // Разные области
        Area moscow = new City("Moscow", 55, 37, 12500000, 95);
        Area maldives = new CoastalArea("Maldives", 3, 73, "Индийский океан");

        // Вывод информации
        WeatherOnArea snowyInMoscow = new WeatherOnArea(snowyWeather, moscow);
        WeatherOnArea rainyInMaldives = new WeatherOnArea(rainyWeather, maldives);
        WeatherOnArea sunnyInMoscow = new WeatherOnArea(sunnyWeather, moscow);
        WeatherOnArea foggyInMaldives = new WeatherOnArea(foggyWeather, maldives);

        // Печатаем информацию для каждой комбинации области и погоды
        System.out.println();

        System.out.println(snowyInMoscow);
        System.out.println(rainyInMaldives);
        System.out.println(sunnyInMoscow);
        System.out.println(foggyInMaldives);
    }
}
