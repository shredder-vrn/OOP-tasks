package vsu.cs.Task9.Weather;

import java.util.Objects;

public class RainyWeather extends Weather {

    public RainyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description) {
        // Устанавливаем иконку дождя в родительский класс.
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, "\u2614");
        //System.out.println("Конструктор дочернего класса RainyWeather.");
    }

    static {
        //System.out.println("\nСтатический блок дочернего класса RainyWeather.\n");
    }

    {
        //System.out.println("Экземплярный блок дочернего класса RainyWeather.");
    }

    /**
     * Переопределение equals и hashCode с учетом специфики дождевой погоды.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RainyWeather that = (RainyWeather) o;
        return Objects.equals(getWeatherIcon(), that.getWeatherIcon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeatherIcon());
    }

    @Override
    public String toString() {
        return String.format(
                "RainyWeather:\nТемпература: %d°C\nВлажность: %d%%\nСкорость ветра: %d м/с, Направление: %s\n" +
                        "Осадки: %d%%\nОписание: %s\nИконка: %s\n",
                getTemperature(), getAirHumidity(), getWindSpeed(), getWindDirection(),
                getPrecipitationProbability(), getDescription(), getWeatherIcon()
        );
    }

    @Override
    public void updateWeatherConditions() {
        this.setPrecipitationProbability(this.getPrecipitationProbability() + 10);
        this.setDescription("Дождь усиливается");
        System.out.println("Обновлены условия для дождливой погоды.");
    }

}
