package vsu.cs.Task4;

import vsu.cs.Task4.Area.Area;
import vsu.cs.Task4.Area.City;
import vsu.cs.Task4.Area.CoastalArea;
import vsu.cs.Task4.Weather.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        // Создаем области
        List<Area> areas = new ArrayList<>();
        areas.add(new City("Москва", 55, 37, 12500000, 95));
        areas.add(new City("Воронеж", 51, 39, 1000000, 90));
        areas.add(new CoastalArea("Мурманск", 69, 33, "Баренцево море"));

        // Создаем погодные условия
        List<Weather> weathers = new ArrayList<>();
        weathers.add(new SnowyWeather(0, 85, 10, "Северный", 90, "Снежно"));
        weathers.add(new RainyWeather(12, 90, 15, "Южный", 80, "Дождливо"));
        weathers.add(new SunnyWeather(25, 60, 5, "Западный", 0, "Солнечно"));
        weathers.add(new FoggyWeather(8, 100, 0, "Тихий", 20, "Туманно"));

        // Сопоставляем погоду и область
        List<WeatherOnArea> weatherOnAreas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {  // Сократим количество для наглядности
            weatherOnAreas.add(new WeatherOnArea(
                    weathers.get(random.nextInt(weathers.size())),
                    areas.get(random.nextInt(areas.size()))
            ));
        }

        // Выводим все данные
        for (WeatherOnArea weatherOnArea : weatherOnAreas) {
            System.out.println(weatherOnArea);
        }

        System.out.println("\n=== Работа с equals и hashCode для Weather ===");

        // Сравним погоду
        Weather weather1 = new SnowyWeather(0, 85, 10, "Северный", 90, "Снежно");
        Weather weather2 = new SnowyWeather(0, 85, 10, "Северный", 90, "Снежно");
        Weather weather3 = new SunnyWeather(25, 60, 5, "Западный", 0, "Солнечно");

        System.out.println("weather1.equals(weather2): " + weather1.equals(weather2)); // true
        System.out.println("weather1.equals(weather3): " + weather1.equals(weather3)); // false
        System.out.println("weather1.hashCode(): " + weather1.hashCode());
        System.out.println("weather2.hashCode(): " + weather2.hashCode());
        System.out.println("weather3.hashCode(): " + weather3.hashCode());

        System.out.println("\n=== Работа с equals и hashCode для Area ===");

        // Создаем области для проверки
        Area city1 = new City("Москва", 55, 37, 12500000, 95);
        Area city2 = new City("Москва", 55, 37, 12500000, 95); // Идентичный city1
        Area city3 = new City("Санкт-Петербург", 59, 30, 5000000, 80); // Другой город
        Area coastal1 = new CoastalArea("Мурманск", 69, 33, "Баренцево море");
        Area coastal2 = new CoastalArea("Мурманск", 69, 33, "Белое море"); // Разное море

        System.out.println("\n=== Работа с equalsByNameAndCoordinates и hashCodeByNameAndCoordinates для Area ===");

        // Проверяем, что сравнение по значимым полям работает правильно
        System.out.println("city1.equalsByNameAndCoordinates(city2): " + city1.equalsByNameAndCoordinates(city2)); // true
        System.out.println("city1.equalsByNameAndCoordinates(city3): " + city1.equalsByNameAndCoordinates(city3)); // false
        System.out.println("coastal1.equalsByNameAndCoordinates(coastal2): " + coastal1.equalsByNameAndCoordinates(coastal2)); // true

        // Выводим хэш-коды по значимым полям
        System.out.println("city1.hashCodeByNameAndCoordinates(): " + city1.hashCodeByNameAndCoordinates());
        System.out.println("city2.hashCodeByNameAndCoordinates(): " + city2.hashCodeByNameAndCoordinates());
        System.out.println("city3.hashCodeByNameAndCoordinates(): " + city3.hashCodeByNameAndCoordinates());
        System.out.println("coastal1.hashCodeByNameAndCoordinates(): " + coastal1.hashCodeByNameAndCoordinates());
        System.out.println("coastal2.hashCodeByNameAndCoordinates(): " + coastal2.hashCodeByNameAndCoordinates());
        System.out.println("coastal1.hashCodeByNameAndCoordinates(): " + coastal1.hashCode());
        System.out.println("coastal1.hashCodeByNameAndCoordinates(): " + coastal2.hashCode());


        System.out.println(coastal1);
        System.out.println(coastal2);


        System.out.println("\n=== Пример переопределения значения по Hash ===");

        // Значимые поля совпадают, но это другой объект
        City city4 = new City("Москва", 55, 37, 15000000, 95);
        City city5 = new City("Москва", 55, 37, 15000000, 95);


        Map<City, String> map = new HashMap<>();
        map.put(city4, "Объект 1");
        map.put(city5, "Объект 2"); // Перезапишет city1, так как hashCode совпадает

        System.out.println("city4 hashCode: " + city4.hashCode());
        System.out.println("city5 hashCode: " + city5.hashCode());
        System.out.println("Map contents: " + map);
        System.out.println("city4 equals city5: " + city4.equals(city5));


        System.out.println(map.size());
        System.out.println(map.get(city5));

    }
}
