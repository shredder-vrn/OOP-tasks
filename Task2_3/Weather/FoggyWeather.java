package vsu.cs.Task2_3.Weather;

public class FoggyWeather extends Weather {

    private String weatherIcon = "\u2601";

    public FoggyWeather(int temperature, int airHumidity, int windSpeed, String windDirection,
                        int precipitationProbability, String description, String weatherIcon) {
        super(temperature, airHumidity, windSpeed, windDirection, precipitationProbability, description, weatherIcon);
        System.out.println("Конструктор дочернего класса FoggyWeather.");
    }

    static {
        System.out.println("\nСтатический блок дочернего класса FoggyWeather.\n");
    }

    {
        System.out.println("Экземплярный(нестатический) блок дочернего класса FoggyWeather.");
    }

    @Override
    public String toString() {
        return "FoggyWeather{" +
                "weatherIcon='" + weatherIcon + '\'' +
                "} " + super.toString();
    }
}
