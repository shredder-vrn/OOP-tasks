package vsu.cs.Task10.WeatherDTO;
import java.util.Objects;

public class SunnyWeatherDTO {
    private int temperature;
    private int airHumidity;
    private int windSpeed;
    private String windDirection;
    private String description;

    public SunnyWeatherDTO(int temperature, int airHumidity, int windSpeed, String windDirection, String description) {
        this.temperature = temperature;
        this.airHumidity = airHumidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.description = description;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getAirHumidity() {
        return airHumidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format(
                "SunnyWeatherDTO:\nТемпература: %d°C\nВлажность: %d%%\nСкорость ветра: %d м/с, Направление: %s\nОписание: %s\n",
                temperature, airHumidity, windSpeed, windDirection, description
        );
    }
}
