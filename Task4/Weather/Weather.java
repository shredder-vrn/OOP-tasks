package vsu.cs.Task4.Weather;

import java.util.Objects;

public abstract class Weather {

    private int temperature;
    private int airHumidity;
    private int windSpeed;
    private String windDirection;
    private int precipitationProbability;
    private String description;
    private String weatherIcon;

    private static final String climate = "Континентально-циклонический климат";

    public Weather(int temperature, int airHumidity, int windSpeed, String windDirection,
                   int precipitationProbability, String description, String weatherIcon) {
        this.temperature = temperature;
        this.airHumidity = airHumidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.precipitationProbability = precipitationProbability;
        this.description = description;
        this.weatherIcon = weatherIcon;
        //System.out.println("Конструктор Weather.");
    }

    public Weather() {
    }

    static {
        //System.out.println("\n" + climate + "\nСтатический блок родительского класса Weather.");
    }

    {
        //System.out.println("Экземплярный блок родительского класса Weather.");
    }

    // Методы equals и hashCode для сравнения объектов.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return temperature == weather.temperature &&
                airHumidity == weather.airHumidity &&
                windSpeed == weather.windSpeed &&
                precipitationProbability == weather.precipitationProbability &&
                Objects.equals(windDirection, weather.windDirection) &&
                Objects.equals(description, weather.description) &&
                Objects.equals(weatherIcon, weather.weatherIcon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(int airHumidity) {
        this.airHumidity = airHumidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public int getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void printInfo() {
        System.out.println("Температура: " + temperature + "°C");
        System.out.println("Влажность: " + airHumidity + "%");
        System.out.println("Скорость ветра: " + windSpeed + " м/с");
        System.out.println("Направление ветра: " + windDirection);
        System.out.println("Вероятность осадков: " + precipitationProbability + "%");
        System.out.println("Описание: " + description);
        System.out.println("Иконка погоды: " + weatherIcon);
    }

    public String toDetailedString() {
        return String.format(
                "Погода: %s\nТемпература: %d°C\nВлажность: %d%%\nВетер: %d м/с, %s\nОсадки: %d%%\nОписание: %s\nИконка: %s\n",
                climate, temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon
        );
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature=" + temperature +
                ", airHumidity=" + airHumidity +
                ", windSpeed=" + windSpeed +
                ", windDirection='" + windDirection + '\'' +
                ", precipitationProbability=" + precipitationProbability +
                ", description='" + description + '\'' +
                ", weatherIcon='" + weatherIcon + '\'' +
                ", climate='" + climate + '\'' +
                '}';
    }

    /**
     * Абстрактный метод для событий погоды.
     * Например, можно реализовать "изменение прогноза".
     */
    public abstract void updateWeatherConditions();
}