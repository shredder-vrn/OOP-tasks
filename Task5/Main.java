package vsu.cs.Task5;

import vsu.cs.Task5.Area.Area;
import vsu.cs.Task5.Area.City;
import vsu.cs.Task5.Area.CoastalArea;
import vsu.cs.Task5.Interfaces.AreaPredicate;
import vsu.cs.Task5.Weather.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем список объектов
        List<Area> areas = new ArrayList<>();
        areas.add(new City("Москва", 55, 37, 12000000, 95));
        areas.add(new City("Санкт-Петербург", 59, 30, 5000000, 90));
        areas.add(new City("Новосибирск", 55, 82, 1600000, 80));
        areas.add(new City("Казань", 55, 49, 1200000, 85));
        areas.add(new City("Екатеринбург", 56, 60, 1500000, 88));
        areas.add(new City("Владивосток", 43, 131, 600000, 75));

        // === Демонстрация работы методов интерфейса Geographical ===
        System.out.println("=== Демонстрация Geographical ===");

        Area moscow = areas.get(0);

        for (Area area : areas) {
            System.out.printf("Находится ли %s в пределах 20 единиц от Москвы? %s%n",
                    area, moscow.isWithinRange(area.getLatitude(), area.getLongitude(), 20));
        }

        // === Демонстрация работы функционального интерфейса AreaPredicate ===
        System.out.println("\n=== Демонстрация AreaPredicate ===");

        // Полная запись фильтра для высокого населения
        AreaPredicate highPopulation = new AreaPredicate() {
            @Override
            public boolean test(Area area) {
                if (area instanceof City) {
                    City city = (City) area;
                    return city.getPopulation() > 5000000;
                }
                return false;
            }
        };

        // Полная запись фильтра для умеренной урбанизации
        AreaPredicate moderateUrbanization = new AreaPredicate() {
            @Override
            public boolean test(Area area) {
                if (area instanceof City) {
                    City city = (City) area;
                    return city.getUrbanizationLevel() >= 85 && city.getUrbanizationLevel() <= 95;
                }
                return false;
            }
        };

        // Полная запись фильтра для близости к Москве, уникальная логика
        AreaPredicate nearMoscow = new AreaPredicate() {
            @Override
            public boolean test(Area area) {
                // Измененная логика: проверяем только широту (latitude)
                return Math.abs(area.getLatitude() - moscow.getLatitude()) <= 20;
            }
        };

        // Используем фильтрацию
        System.out.println("Города с населением более 5 млн:");
        filterAreas(areas, highPopulation).forEach(System.out::println);

        System.out.println("\nГорода с уровнем урбанизации от 85 до 95:");
        filterAreas(areas, moderateUrbanization).forEach(System.out::println);

        System.out.println("\nГорода в пределах 20 единиц от Москвы (по широте):");
        filterAreas(areas, nearMoscow).forEach(System.out::println);

        // Комбинация условий
        System.out.println("\nГорода с населением более 1 млн и урбанизацией > 85:");

        filterAreas(areas, new AreaPredicate() {
            @Override
            public boolean test(Area area) {
                if (area instanceof City) {
                    City city = (City) area;
                    return city.getPopulation() > 1000000 && city.getUrbanizationLevel() > 85;
                }
                return false;
            }
        }).forEach(System.out::println);
    }

    public static List<Area> filterAreas(List<Area> areas, AreaPredicate predicate) {
        List<Area> result = new ArrayList<>();
        for (Area area : areas) {
            if (predicate.test(area)) {
                result.add(area);
            }
        }
        return result;
    }
}