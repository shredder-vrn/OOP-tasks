package vsu.cs.Task2_3.Weather;

public class SunnyWeather extends Weather {

    private String weatherIcon = "\u2600";

    public SunnyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
        System.out.println("Конструктор дочернего класса SunnyWeather.");
    }

    static {
        System.out.println("\nСтатический блок дочернего класса SunnyWeather.\n");
    }

    {
        System.out.println("Экземплярный(нестатический) блок дочернего класса SunnyWeather.");
    }


    @Override
    public String toString() {
        return "SunnyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}