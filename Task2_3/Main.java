package vsu.cs.Task2_3;

import vsu.cs.Task2_3.Area.Area;
import vsu.cs.Task2_3.Area.City;
import vsu.cs.Task2_3.Area.CoastalArea;
import vsu.cs.Task2_3.Weather.*;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Random random = new Random();

        List<Area> areas = new ArrayList<>();
        areas.add(new City("Москва", 55, 37, 12500000, 95));
        areas.add(new City("Воронеж", 55, 37, 12500000, 95));
        areas.add(new CoastalArea("Мурманск", 55, 37, "Широка река"));

        List<Weather> weathers = new ArrayList<>();
        weathers.add(new SnowyWeather(0, 85, 10, "Северный", 90, "Снежно", "Снежная иконка"));
        weathers.add(new RainyWeather(12, 90, 15, "Южный", 80, "Дождливо", "Дождевая иконка"));
        weathers.add(new SunnyWeather(25, 60, 5, "Западный", 0, "Солнечно", "Солнечная иконка"));
        weathers.add(new FoggyWeather(8, 100, 0, "Тихий", 20, "Туманно", "Туманная иконка"));

        List<WeatherOnArea> weatherOnAreas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            weatherOnAreas.add(new WeatherOnArea(weathers.get(random.nextInt(weathers.size())), areas.get(random.nextInt(areas.size()))));
        }

        Map<String, Integer> classCountMap = new HashMap<>();
        Map<String, Integer> classParentCountMap = new HashMap<>();
        for (Area area : areas) {
            if(area.isCheck()){
                String className = area.getClassName();
                String classParentName = area.getParentClassName();
                classCountMap.put(className, classCountMap.getOrDefault(className, 0) + 1);
                classParentCountMap.put(classParentName, classParentCountMap.getOrDefault(classParentName, 0) + 1);
            }
        }

        System.out.println("\nРодительские классы: "+classParentCountMap+"\nДочерние классы: "+classCountMap+"\n");

        for (WeatherOnArea weatherOnArea:weatherOnAreas) {
            System.out.println(weatherOnArea);
        }
    }
}
