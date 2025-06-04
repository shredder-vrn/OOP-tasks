package vsu.cs.Task10;

import vsu.cs.Task10.Weather.SunnyWeather;
import vsu.cs.Task10.WeatherDTO.SunnyWeatherDTO;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherConverter {

    public static void main(String[] args) {
        List<SunnyWeather> sunnyWeatherList = List.of(
                new SunnyWeather(25, 40, 5, "Северо-Запад", 0, "Ясно"),
                new SunnyWeather(30, 35, 3, "Восток", 0, "Жарко"),
                new SunnyWeather(20, 50, 6, "Юг", 0, "Тепло")
        );

        List<SunnyWeatherDTO> dtoList = sunnyWeatherList.stream()
                .map(WeatherConverter::convertToDTO)
                .toList();

        System.out.println(dtoList.stream()
                .map(SunnyWeatherDTO::toString)
                .collect(Collectors.joining("\n")));
    }

    public static SunnyWeatherDTO convertToDTO(SunnyWeather sunnyWeather) {
        return new SunnyWeatherDTO(
                sunnyWeather.getTemperature(),
                sunnyWeather.getAirHumidity(),
                sunnyWeather.getWindSpeed(),
                sunnyWeather.getWindDirection(),
                sunnyWeather.getDescription()
        );
    }
}
