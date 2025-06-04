package vsu.cs.Task6.Weather;

import java.util.Objects;

public class SunnyWeather extends Weather {

    public SunnyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description) {
        // Устанавливаем иконку солнечной погоды в родительский класс.
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, "\u2600");
        //System.out.println("Конструктор дочернего класса SunnyWeather.");
    }

    static {
        //System.out.println("\nСтатический блок дочернего класса SunnyWeather.\n");
    }

    {
        //System.out.println("Экземплярный блок дочернего класса SunnyWeather.");
    }

    /**
     * Переопределение equals и hashCode с учетом специфики солнечной погоды.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SunnyWeather that = (SunnyWeather) o;
        return Objects.equals(getWeatherIcon(), that.getWeatherIcon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeatherIcon());
    }

    @Override
    public String toString() {
        return String.format(
                "SunnyWeather:\nТемпература: %d°C\nВлажность: %d%%\nСкорость ветра: %d м/с, Направление: %s\n" +
                        "Осадки: %d%%\nОписание: %s\nИконка: %s\n",
                getTemperature(), getAirHumidity(), getWindSpeed(), getWindDirection(),
                getPrecipitationProbability(), getDescription(), getWeatherIcon()
        );
    }
    @Override
    public void updateWeatherConditions() {
        this.setTemperature(this.getTemperature() + 2);
        this.setDescription("Становится жарче");
        System.out.println("Обновлены условия для солнечной погоды.");
    }

}
