package vsu.cs.Task9.Weather;

import java.util.Objects;

public class FoggyWeather extends Weather {

    public FoggyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description) {
        // Устанавливаем иконку для туманной погоды в родительский класс.
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, "\u2601");
        //System.out.println("Конструктор дочернего класса FoggyWeather.");
    }

    static {
        //System.out.println("\nСтатический блок дочернего класса FoggyWeather.\n");
    }

    {
        //System.out.println("Экземплярный блок дочернего класса FoggyWeather.");
    }

    /**
     * Переопределение equals и hashCode с учетом специфики туманной погоды.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoggyWeather that = (FoggyWeather) o;
        return Objects.equals(getWeatherIcon(), that.getWeatherIcon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeatherIcon());
    }

    @Override
    public String toString() {
        return String.format(
                "FoggyWeather:\nТемпература: %d°C\nВлажность: %d%%\nСкорость ветра: %d м/с, Направление: %s\n" +
                        "Осадки: %d%%\nОписание: %s\nИконка: %s\n",
                getTemperature(), getAirHumidity(), getWindSpeed(), getWindDirection(),
                getPrecipitationProbability(), getDescription(), getWeatherIcon()
        );
    }

    @Override
    public void updateWeatherConditions() {
        this.setAirHumidity(this.getAirHumidity() + 5);
        this.setDescription("Туман становится плотнее");
        System.out.println("Обновлены условия для туманной погоды.");
    }

}
