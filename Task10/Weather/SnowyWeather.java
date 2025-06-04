package vsu.cs.Task10.Weather;

import java.util.Objects;

public class SnowyWeather extends Weather {

    public SnowyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description) {
        // Устанавливаем иконку снежной погоды в родительский класс.
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, "\u2744");
        //System.out.println("Конструктор дочернего класса SnowyWeather.");
    }

    static {
        //System.out.println("\nСтатический блок дочернего класса SnowyWeather.\n");
    }

    {
        //System.out.println("Экземплярный блок дочернего класса SnowyWeather.");
    }

    /**
     * Переопределение equals и hashCode с учетом специфики снежной погоды.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SnowyWeather that = (SnowyWeather) o;
        return Objects.equals(getWeatherIcon(), that.getWeatherIcon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeatherIcon());
    }

    @Override
    public String toString() {
        return String.format(
                "SnowyWeather:\nТемпература: %d°C\nВлажность: %d%%\nСкорость ветра: %d м/с, Направление: %s\n" +
                        "Осадки: %d%%\nОписание: %s\nИконка: %s\n",
                getTemperature(), getAirHumidity(), getWindSpeed(), getWindDirection(),
                getPrecipitationProbability(), getDescription(), getWeatherIcon()
        );
    }

    @Override
    public void updateWeatherConditions() {
        this.setTemperature(this.getTemperature() - 2);
        this.setDescription("Снег усиливается");
        System.out.println("Обновлены условия для снежной погоды.");
    }

}
