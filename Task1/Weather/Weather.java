package vsu.cs.Task1.Weather;

/**
 * Абстрактный класс "погода"
 */

public abstract class Weather {

    /**
     * Поля класса "погода". Делаем приватными.
     */
    private int temperature;
    private int airHumidity;
    private int windSpeed;
    private String windDirection;
    private int precipitationProbability;
    private String description;
    private String weatherIcon;

    private String additionalInfo = "Общая информация о погоде";




    /**
     * Конструкторы для создания объекта с полями
     */
    public Weather(int temperature, int airHumidity, int windSpeed, String windDirection,
                   int precipitationProbability, String description, String weatherIcon) {
        this.temperature = temperature;
        this.airHumidity = airHumidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.precipitationProbability = precipitationProbability;
        this.description = description;
        this.weatherIcon = weatherIcon;
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

    /**
     * Методы класса
     */

    public void printInfo() {
        System.out.println("Температура: " + temperature + "°C");
        System.out.println("Влажность: " + airHumidity + "%");
        System.out.println("Скорость ветра: " + windSpeed + " м/с");
        System.out.println("Направление ветра: " + windDirection);
        System.out.println("Вероятность осадков: " + precipitationProbability + "%");
        System.out.println("Описание: " + description);
        System.out.println("Иконка погоды: " + weatherIcon);
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
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
