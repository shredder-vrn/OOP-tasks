package vsu.cs.Task10;

import vsu.cs.Task10.Area.Area;
import vsu.cs.Task10.Weather.Weather;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class WeatherOnArea {
    private Weather weather;
    private Area area;


    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public WeatherOnArea(Weather weather, Area area, String startDateTime, String endDateTime) {
        if (weather == null || area == null) {
            throw new IllegalArgumentException("Погода и область не могут быть null.");
        }
        this.weather = weather;
        this.area = area;
        this.startDateTime = parseDateTime(startDateTime);
        this.endDateTime = parseDateTime(endDateTime);
    }

    private LocalDateTime parseDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты. Используйте: dd-MM-yyyy HH:mm");
        }
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

    public String getStartDateTime() {
        return startDateTime.format(FORMATTER);
    }

    public String getEndDateTime() {
        return endDateTime.format(FORMATTER);
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = parseDateTime(startDateTime);
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = parseDateTime(endDateTime);
    }

    public long calculateDurationInHours() {
        return Duration.between(startDateTime, endDateTime).toHours();
    }

    public String getFormattedDuration() {
        Duration duration = Duration.between(startDateTime, endDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return " часы: "+ hours + " минуты: " + minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherOnArea that = (WeatherOnArea) o;
        return Objects.equals(weather, that.weather) &&
                Objects.equals(area, that.area) &&
                Objects.equals(startDateTime, that.startDateTime) &&
                Objects.equals(endDateTime, that.endDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weather, area, startDateTime, endDateTime);
    }

    public void printInfo() {
        System.out.println("Область: " + area.toString());
        System.out.println("Погода: " + weather.toString());
        System.out.println("Начало: " + getStartDateTime());
        System.out.println("Конец: " + getEndDateTime());
        System.out.println("Длительность: " + getFormattedDuration());
    }

    @Override
    public String toString() {
        return String.format("WeatherOnArea [Область: %s, Погода: %s, Начало: %s, Конец: %s]",
                area.toString(), weather.toString(), getStartDateTime(), getEndDateTime());
    }
}


/*
Список. Создать класс SunnyWeatherDTO
С помощью потоков перевести SunnyWeather в SunnyWeatherDTO
 */