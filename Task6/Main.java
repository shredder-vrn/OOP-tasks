package vsu.cs.Task6;

import vsu.cs.Task6.Area.Area;
import vsu.cs.Task6.Area.City;
import vsu.cs.Task6.Area.CoastalArea;
import vsu.cs.Task6.Exceptions.DuplicateAreaException;
import vsu.cs.Task6.Exceptions.InvalidLocationException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Area> areas = new ArrayList<>();

        try {
            // Создаем города
            City city1 = new City("Москва", 55, 37, 12000000, 95);
            City city2 = new City("Сочи", 43, 39, 400000, 85);
            areas.add(city1);
            areas.add(city2);

            // Создаем прибрежные зоны
            CoastalArea coastal1 = new CoastalArea("Черное море", 44, 39, "Море");
            CoastalArea coastal2 = new CoastalArea("Байкал", 53, 108, "Озеро");
            areas.add(coastal1);
            areas.add(coastal2);

            // Проверяем некорректные данные
            try {
                City city3 = new City("Некорректный", -91, 200, 1000, 20);
                areas.add(city3);
            } catch (InvalidLocationException e) {
                System.err.println("Ошибка создания города: " + e.getMessage());
            }

            try {
                City duplicateCity = new City("Москва", 55, 37, 12000000, 95);
                areas.add(duplicateCity);
            } catch (DuplicateAreaException e) {
                System.err.println("Ошибка создания города: " + e.getMessage());
            }

            try {
                CoastalArea coastal3 = new CoastalArea("Черное море", -95, 39, "Море");
                areas.add(coastal3);
            } catch (InvalidLocationException e) {
                System.err.println("Ошибка создания прибрежной зоны: " + e.getMessage());
            }

            try {
                CoastalArea duplicateCoastal = new CoastalArea("Черное море", 44, 39, "Море");
                areas.add(duplicateCoastal);
            } catch (DuplicateAreaException e) {
                System.err.println("Ошибка создания прибрежной зоны: " + e.getMessage());
            }

            // Фильтрация городов с населением больше 1 млн
            List<City> bigCities = areas.stream()
                    .filter(area -> area instanceof City && ((City) area).getPopulation() > 1000000)
                    .map(area -> (City) area)
                    .toList();

            System.out.println("\nГорода с населением больше 1 миллиона:");
            bigCities.forEach(System.out::println);

            // Фильтрация прибрежных зон с типом водоема "Озеро"
            List<CoastalArea> lakes = areas.stream()
                    .filter(area -> area instanceof CoastalArea && ((CoastalArea) area).getWaterBodyType().equals("Озеро"))
                    .map(area -> (CoastalArea) area)
                    .toList();

            System.out.println("\nПрибрежные зоны с типом водоема 'Озеро':");
            lakes.forEach(System.out::println);

            // Сортировка всех зон по широте
            areas.sort(Comparator.comparingInt(Area::getLatitude));

            System.out.println("\nВсе зоны, отсортированные по широте:");
            areas.forEach(System.out::println);

            // Вывод информации о всех объектах
            System.out.println("\nПодробная информация:");
            for (Area area : areas) {
                System.out.printf(
                        "Название: %s, Тип: %s, Координаты: (%d, %d)\n",
                        area.getName(),
                        area.getLocationType(),
                        area.getLatitude(),
                        area.getLongitude()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
