package vsu.cs.Task7;

import vsu.cs.Task7.Area.City;
import vsu.cs.Task7.Weather.SnowyWeather;
import vsu.cs.Task7.Weather.RainyWeather;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Список городов
            List<City> cities = new ArrayList<>();
            cities.add(new City("Воронеж", 51, 39, 1050000, 85));
            cities.add(new City("Москва", 55, 37, 12615000, 97));
            cities.add(new City("Новосибирск", 55, 83, 1625600, 70));

            // Список погодных условий
            List<SnowyWeather> snowyWeathers = new ArrayList<>();
            snowyWeathers.add(new SnowyWeather(-5, 85, 10, "Северный", 90, "Снегопад"));
            snowyWeathers.add(new SnowyWeather(-10, 80, 15, "Западный", 75, "Снег с дождем"));

            List<RainyWeather> rainyWeathers = new ArrayList<>();
            rainyWeathers.add(new RainyWeather(10, 95, 20, "Южный", 60, "Ливень"));
            rainyWeathers.add(new RainyWeather(15, 80, 5, "Восточный", 50, "Кратковременные дожди"));

            // Список временных интервалов
            List<String[]> dateIntervals = new ArrayList<>();
            dateIntervals.add(new String[]{"21-12-2024 09:46", "29-12-2024 23:30"});
            dateIntervals.add(new String[]{"10-01-2025 12:00", "15-01-2025 18:00"});
            dateIntervals.add(new String[]{"01-02-2025 08:30", "07-02-2025 20:15"});

            // Обработка данных
            for (int i = 0; i < cities.size(); i++) {
                City city = cities.get(i);
                SnowyWeather snowyWeather = snowyWeathers.get(i % snowyWeathers.size());
                String[] dateInterval = dateIntervals.get(i % dateIntervals.size());

                // Создаем объект WeatherOnArea
                WeatherOnArea weatherOnArea = new WeatherOnArea(
                        snowyWeather,
                        city,
                        dateInterval[0],
                        dateInterval[1]
                );

                // Вывод информации
                System.out.println("\nИнформация о погоде в городе " + city.getName() + ":");
                weatherOnArea.printInfo();

                // Работа с Duration
                long durationInHours = weatherOnArea.calculateDurationInHours();
                String formattedDuration = weatherOnArea.getFormattedDuration();
                System.out.println("Длительность в часах: " + durationInHours);
                System.out.println("Форматированная длительность: " + formattedDuration);
                System.out.println("Длительность в минутах: " + calculateTotalMinutes(weatherOnArea));
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }


    /**
     * Рассчитывает общую длительность погодного события в минутах.
     * @param weatherOnArea объект WeatherOnArea.
     * @return длительность в минутах.
     */
    public static long calculateTotalMinutes(WeatherOnArea weatherOnArea) {
        return Duration.between(
                LocalDateTime.parse(weatherOnArea.getStartDateTime(), WeatherOnArea.FORMATTER),
                LocalDateTime.parse(weatherOnArea.getEndDateTime(), WeatherOnArea.FORMATTER)
        ).toMinutes();
    }
}
