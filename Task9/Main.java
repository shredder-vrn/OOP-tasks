package vsu.cs.Task9;

import vsu.cs.Task9.Area.City;
import vsu.cs.Task9.Weather.RainyWeather;
import vsu.cs.Task9.Weather.SnowyWeather;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            // Список городов
            List<City> cities = List.of(
                    new City("Воронеж", 51, 39, 1050000, 85),
                    new City("Москва", 55, 37, 12615000, 97),
                    new City("Новосибирск", 55, 83, 1625600, 70)
            );

            // Список погодных условий
            List<SnowyWeather> snowyWeathers = List.of(
                    new SnowyWeather(-5, 85, 10, "Северный", 90, "Снегопад"),
                    new SnowyWeather(-10, 80, 15, "Западный", 75, "Снег с дождем")
            );

            List<RainyWeather> rainyWeathers = List.of(
                    new RainyWeather(10, 95, 20, "Южный", 60, "Ливень"),
                    new RainyWeather(15, 80, 5, "Восточный", 50, "Кратковременные дожди")
            );

            // Список временных интервалов
            List<String[]> dateIntervals = List.of(
                    new String[]{"21-12-2024 09:46", "29-12-2024 23:30"},
                    new String[]{"10-01-2025 12:00", "15-01-2025 18:00"},
                    new String[]{"01-02-2025 08:30", "07-02-2025 20:15"}
            );

            // Создание списка WeatherOnArea с использованием Stream API
            List<WeatherOnArea> weatherData = cities.stream()
                    .map(city -> {
                        int index = cities.indexOf(city); // Определяем индекс текущего города
                        SnowyWeather snowyWeather = snowyWeathers.get(index % snowyWeathers.size()); // Выбираем соответствующую погоду
                        String[] dateInterval = dateIntervals.get(index % dateIntervals.size()); // Берем интервал времени
                        return new WeatherOnArea(
                                snowyWeather,
                                city,
                                dateInterval[0],
                                dateInterval[1]
                        );
                    })
                    .toList();

            // Вывод всей информации с использованием forEach
            weatherData.forEach(weatherOnArea -> {
                System.out.println("\nИнформация о погоде в городе " + weatherOnArea.getArea().getName() + ":");
                weatherOnArea.printInfo();
                System.out.println("Длительность в часах: " + weatherOnArea.calculateDurationInHours());
                System.out.println("Форматированная длительность: " + weatherOnArea.getFormattedDuration());
                System.out.println("Длительность в минутах: " + calculateTotalMinutes(weatherOnArea));
            });

            // Группировка данных на основе продолжительности с partitioningBy
            Map<Boolean, List<WeatherOnArea>> groupedByDuration = weatherData.stream()
                    .collect(Collectors.partitioningBy(weather -> weather.calculateDurationInHours() > 100));
            System.out.println("\nСобытия с длительностью более 100 часов: ");
            groupedByDuration.get(true).forEach(WeatherOnArea::printInfo);

            System.out.println("\nСобытия с длительностью менее 100 часов: ");
            groupedByDuration.get(false).forEach(WeatherOnArea::printInfo);

            // Вычисление средней длительности с mapToLong и average
            double averageDuration = weatherData.stream()
                    .mapToLong(WeatherOnArea::calculateDurationInHours)
                    .average()
                    .orElse(0);
            System.out.println("\nСредняя длительность погодных событий в часах: " + averageDuration);
// Самое длительное событие с max
            weatherData.stream()
                    .max(Comparator.comparingLong(WeatherOnArea::calculateDurationInHours))
                    .ifPresent(longestEvent -> {
                        System.out.println("\nСамое длительное событие:");
                        longestEvent.printInfo();
                    });

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
